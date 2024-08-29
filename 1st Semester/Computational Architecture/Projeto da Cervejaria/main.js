// não altere!
const serialport = require('serialport');
const express = require('express');
const mysql = require('mysql2');
const sql = require('mssql');

// não altere!
const SERIAL_BAUD_RATE = 9600;
const SERVIDOR_PORTA = 3300;

// configure a linha abaixo caso queira que os dados capturados sejam inseridos no banco de dados.
// false -> nao insere
// true -> insere
const HABILITAR_OPERACAO_INSERIR = true;

// altere o valor da variável AMBIENTE para o valor desejado:
// API conectada ao banco de dados remoto, SQL Server -> 'producao'
// API conectada ao banco de dados local, MySQL Workbench - 'desenvolvimento'
const AMBIENTE = 'desenvolvimento';

const serial = async (
    valoresMaceracao,
    valoresMalteacao_etapa1,
    valoresMalteacao_etapa2,
    valoresMalteacao_etapa3,
    valoresMoagem,
    valoresBrassagem_etapa1,
    valoresBrassagem_etapa2,
    valoresBrassagem_etapa3,
    valoresFervura,
    valoresResfriamento_etapa1,
    valoresResfriamento_etapa2,
    valoresResfriamento_etapa3,
    valoresFiltragem,
    valoresPasteurizacao,
    valoresEnvase
) => {
    let poolBancoDados = ''

    if (AMBIENTE == 'desenvolvimento') {
        poolBancoDados = mysql.createPool(
            {
                // altere!
                // CREDENCIAIS DO BANCO LOCAL - MYSQL WORKBENCH
                host: 'localhost',
                user: 'root',
                password: 'sptech',
                database: 'ambevy'
            }
        ).promise();
    } else if (AMBIENTE == 'producao') {
        console.log('Projeto rodando inserindo dados em nuvem. Configure as credenciais abaixo.');
    } else {
        throw new Error('Ambiente não configurado. Verifique o arquivo "main.js" e tente novamente.');
    }


    const portas = await serialport.SerialPort.list();
    const portaArduino = portas.find((porta) => porta.vendorId == 2341 && porta.productId == 43);
    if (!portaArduino) {
        throw new Error('O arduino não foi encontrado em nenhuma porta serial');
    }
    const arduino = new serialport.SerialPort(
        {
            path: portaArduino.path,
            baudRate: SERIAL_BAUD_RATE
        }
    );
    arduino.on('open', () => {
        console.log(`A leitura do arduino foi iniciada na porta ${portaArduino.path} utilizando Baud Rate de ${SERIAL_BAUD_RATE}`);
    });
    arduino.pipe(new serialport.ReadlineParser({ delimiter: '\r\n' })).on('data', async (data) => {
        console.log(data);
        const valores = data.split(';');
        const maceracao = parseFloat(valores[0]);
        const malteacao_etapa1 = parseFloat(valores[1]);
        const malteacao_etapa2 = parseFloat(valores[2]);
        const malteacao_etapa3 = parseFloat(valores[3]);
        const moagem = parseInt(valores[4]);
        const brassagem_etapa1 = parseFloat(valores[5]);
        const brassagem_etapa2 = parseInt(valores[6]);
        const brassagem_etapa3 = parseFloat(valores[7]);
        const fervura = parseInt(valores[8]);
        const resfriamento_etapa1 = parseInt(valores[9]);
        const resfriamento_etapa2 = parseInt(valores[10]);
        const resfriamento_etapa3 = parseInt(valores[11]);
        const filtragem = parseInt(valores[12]);
        const pasteurizacao = parseInt(valores[13]);
        const envase = parseInt(valores[14]);

        valoresMaceracao.push(maceracao);
        valoresMalteacao_etapa1.push(malteacao_etapa1);
        valoresMalteacao_etapa2.push(malteacao_etapa2);
        valoresMalteacao_etapa3.push(malteacao_etapa3);
        valoresMoagem.push(moagem);
        valoresBrassagem_etapa1.push(brassagem_etapa1);
        valoresBrassagem_etapa2.push(brassagem_etapa2);
        valoresBrassagem_etapa3.push(brassagem_etapa3);
        valoresFervura.push(fervura);
        valoresResfriamento_etapa1.push(resfriamento_etapa1);
        valoresResfriamento_etapa2.push(resfriamento_etapa2);
        valoresResfriamento_etapa3.push(resfriamento_etapa3);
        valoresFiltragem.push(filtragem);
        valoresPasteurizacao.push(pasteurizacao);
        valoresEnvase.push(envase);


        if (HABILITAR_OPERACAO_INSERIR) {
            if (AMBIENTE == 'producao') {
                // altere!
                // Este insert irá inserir os dados na tabela "medida"
                // -> altere nome da tabela e colunas se necessário
                // Este insert irá inserir dados de fk_aquario id=1 (fixo no comando do insert abaixo)
                // >> Importante! você deve ter o aquario de id 1 cadastrado.
                // sqlquery = `INSERT INTO lager (data_hora, maceracao, malteacao_etapa1, malteacao_etapa2, malteacao_etapa3, moagem, brassagem_etapa1, brassagem_etapa2, brassagem_etapa3, fervura,  refriamento_etapa1, refriamento_etapa2, refriamento_etapa3, filtragem, pasteurizacao, envase) VALUES (CURRENT_TIMESTAMP, ${maceracao}, ${malteacao_etapa1}, ${malteacao_etapa2}, ${malteacao_etapa3}, ${moagem}, ${brassagem_etapa1}, ${brassagem_etapa2}, ${brassagem_etapa3}, ${fervura}, ${resfriamento_etapa1}, ${resfriamento_etapa2}, ${resfriamento_etapa3}, ${filtragem}, ${pasteurizacao}, ${envase})`;

                // CREDENCIAIS DO BANCO REMOTO - SQL SERVER
                // Importante! você deve ter criado o usuário abaixo com os comandos presentes no arquivo
                // "script-criacao-usuario-sqlserver.sql", presente neste diretório.
                const connStr = "Server=servidor-acquatec.database.windows.net;Database=bd-acquatec;User Id=usuarioParaAPIArduino_datawriter;Password=#Gf_senhaParaAPI;";

                sql.connect(connStr)
                .then(conn => inserirComando(conn, sqlquery))
                    .catch(err => console.log("erro! " + err));

            } else if (AMBIENTE == 'desenvolvimento') {

                // altere!
                // Este insert irá inserir os dados na tabela "medida"
                // -> altere nome da tabela e colunas se necessário
                // Este insert irá inserir dados de fk_aquario id=1 (fixo no comando do insert abaixo)
                // >> você deve ter o aquario de id 1 cadastrado.
                await poolBancoDados.execute(
                    // 'INSERT INTO medida (dht11_umidade, dht11_temperatura, luminosidade, lm35_temperatura, chave, momento, fk_aquario) VALUES (?, ?, ?, ?, ?, now(), 1)',
                    // [dht11Umidade, dht11Temperatura, luminosidade, lm35Temperatura, chave]
                    `INSERT INTO lager (data_hora, maceracao, malteacao_etapa1, malteacao_etapa2, malteacao_etapa3, moagem, brassagem_etapa1, brassagem_etapa2, brassagem_etapa3, fervura,  resfriamento_etapa1, resfriamento_etapa2, resfriamento_etapa3, filtragem, pasteurizacao, envase) VALUES (CURRENT_TIMESTAMP, ${maceracao}, ${malteacao_etapa1}, ${malteacao_etapa2}, ${malteacao_etapa3}, ${moagem}, ${brassagem_etapa1}, ${brassagem_etapa2}, ${brassagem_etapa3}, ${fervura}, ${resfriamento_etapa1}, ${resfriamento_etapa2}, ${resfriamento_etapa3}, ${filtragem}, ${pasteurizacao}, ${envase})`
                );
                // console.log("valores inseridos no banco: ", dht11Umidade + ", " + dht11Temperatura + ", " + luminosidade + ", " + lm35Temperatura + ", " + chave)

            } else {
                throw new Error('Ambiente não configurado. Verifique o arquivo "main.js" e tente novamente.');
            }
        }
    });
    arduino.on('error', (mensagem) => {
        console.error(`Erro no arduino (Mensagem: ${mensagem}`)
    });
}


// não altere!
const servidor = (
    /* valoresDht11Umidade,
     valoresDht11Temperatura,
     valoresLuminosidade,
     valoresLm35Temperatura,
     valoresChave*/
    valoresMaceracao,
    valoresMalteacao_etapa1,
    valoresMalteacao_etapa2,
    valoresMalteacao_etapa3,
    valoresMoagem,
    valoresBrassagem_etapa1,
    valoresBrassagem_etapa2,
    valoresBrassagem_etapa3,
    valoresFervura,
    valoresRefriamento_etapa1,
    valoresRefriamento_etapa2,
    valoresRefriamento_etapa3,
    valoresFiltragem,
    valoresPasteurizacao,
    valoresEnvase
) => {
    const app = express();
    app.use((request, response, next) => {
        response.header('Access-Control-Allow-Origin', '*');
        response.header('Access-Control-Allow-Headers', 'Origin, Content-Type, Accept');
        next();
    });
    app.listen(SERVIDOR_PORTA, () => {
        console.log(`API executada com sucesso na porta ${SERVIDOR_PORTA}`);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresMaceracao);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresMalteacao_etapa1);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresMalteacao_etapa2);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresMalteacao_etapa3);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresMoagem);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresBrassagem_etapa1);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresBrassagem_etapa2);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresBrassagem_etapa3);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresFervura);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresRefriamento_etapa1);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresRefriamento_etapa2);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresRefriamento_etapa3);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresFiltragem);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresPasteurizacao);
    });
    app.get('/sensores/', (_, response) => {
        return response.json(valoresEnvase);
    });
}

(async () => {
    const valoresMaceracao = [];
    const valoresMalteacao_etapa1 = [];
    const valoresMalteacao_etapa2 = [];
    const valoresMalteacao_etapa3 = [];
    const valoresMoagem = [];
    const valoresBrassagem_etapa1 = [];
    const valoresBrassagem_etapa2 = [];
    const valoresBrassagem_etapa3 = [];
    const valoresFervura = [];
    const valoresRefriamento_etapa1 = [];
    const valoresRefriamento_etapa2 = [];
    const valoresRefriamento_etapa3 = [];
    const valoresFiltragem = [];
    const valoresPasteurizacao = [];
    const valoresEnvase = [];

    await serial(
        valoresMaceracao,
        valoresMalteacao_etapa1,
        valoresMalteacao_etapa2,
        valoresMalteacao_etapa3,
        valoresMoagem,
        valoresBrassagem_etapa1,
        valoresBrassagem_etapa2,
        valoresBrassagem_etapa3,
        valoresFervura,
        valoresRefriamento_etapa1,
        valoresRefriamento_etapa2,
        valoresRefriamento_etapa3,
        valoresFiltragem,
        valoresPasteurizacao,
        valoresEnvase
    );
    servidor(
        valoresMaceracao,
        valoresMalteacao_etapa1,
        valoresMalteacao_etapa2,
        valoresMalteacao_etapa3,
        valoresMoagem,
        valoresBrassagem_etapa1,
        valoresBrassagem_etapa2,
        valoresBrassagem_etapa3,
        valoresFervura,
        valoresRefriamento_etapa1,
        valoresRefriamento_etapa2,
        valoresRefriamento_etapa3,
        valoresFiltragem,
        valoresPasteurizacao,
        valoresEnvase
    );
})();
