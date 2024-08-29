const resposta = [
    "cpu",
    "ula",
    "registradores",
    "ram",
    "rom",
    "eprom",
    "flash",
    "memeoria de massa",
    "dma",
    "cs",
    "address bus",
    "data bus"
]

function criarInput() {
    for (var i = 0; i < resposta.length; i++ ){
        boxQuestoes.innerHTML += `                        
        <details class="questao" id="det${i}">
        <summary id="sum${i}">${i+1}° Pergunta</summary>
        <div class="detQuestao">
            <p>
                ${resposta[i]}
            </p>
            <div>
                <input type="text" id="" class="inputQuestao" onkeyup="verificar()" placeholder="Insira aqui a sua resposta">
            </div>
        </div>
    </details>`;

    }
}