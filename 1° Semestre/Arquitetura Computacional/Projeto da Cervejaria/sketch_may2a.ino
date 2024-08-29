#include "DHT.h"
#define dht_type DHT11  //define qual o tipo de sensor DHTxx que se está
//utilizando
/**
* Configurações iniciais sobre os sensores
* DHT11, LM35, LDR5 e TCRT5000
*/
int dht_pin = A2;
DHT dht_1 = DHT(dht_pin, dht_type);  //pode-se configurar diversos
//sensores DHTxx
int lm35_pin = A0, leitura_lm35 = 0;
float temperatura;
float temperatura_maceracao;
float temperatura_malteacao01;
float temperatura_malteacao02;
float temperatura_malteacao03 ;
float temperatura_moagem;
float temperatura_brassagem01;
float temperatura_brassagem02;
float temperatura_brassagem03;
float temperatura_fervura;
float temperatura_resfriamento01;
float temperatura_resfriamento02;
float temperatura_resfriamento03;
float temperatura_filtragem;
float temperatura_pasteurizacao;
float temperatura_envase;

int ldr_pin = A5, leitura_ldr = 0;
int switch_pin = 7;
void setup() {
  Serial.begin(9600);
  // dht_1.begin();
  pinMode(switch_pin, INPUT);
}
void loop() {
  /**
* Bloco do DHT11
*/
  // float umidade = dht_1.readHumidity();
  // float temperatura = dht_1.readTemperature();
  // if (isnan(temperatura) or isnan(umidade))
  // {
  // Serial.println("Erro ao ler o DHT");
  // }
  // else
  // {
  // Serial.print(umidade);
  // Serial.print(";");
  // Serial.print(temperatura);
  // Serial.print(";");
  // }
  /**
* Bloco do LM35
*/
  leitura_lm35 = analogRead(lm35_pin);
  temperatura = leitura_lm35 * (5.0 / 1023) * 100;
  temperatura = leitura_lm35 * (5.0/1023) * 100;
  temperatura_malteacao01 = (0.157 * temperatura + 45.02);
  temperatura_maceracao = (0.236 * temperatura + 7.5);
  temperatura_malteacao02 = (0.39 * temperatura + 62.6);
  temperatura_malteacao03 = (1.18 * temperatura + 52.51);
  temperatura_moagem = (0.78 * temperatura + 47.01);
  temperatura_brassagem01 = (0.39 * temperatura + 27.57);
  temperatura_brassagem02 = (1.18 * temperatura + 32.51);
  temperatura_brassagem03 = (0.39 * temperatura + 54.57);
  temperatura_fervura = (0.15 * temperatura + 97);
  temperatura_resfriamento01 = (0.4 * temperatura + 0.62);
  temperatura_resfriamento02 = (0.4 * temperatura + 4.376);
  temperatura_resfriamento03 = (0.1574 * temperatura + 1.472);
  temperatura_filtragem = (0.157 * temperatura - 2.98);
  temperatura_pasteurizacao = (0.78 * temperatura + 0.09);
  temperatura_envase = (0.39 * temperatura - 5.43);
  Serial.print(temperatura);
  Serial.print(";");
  Serial.print(temperatura_maceracao);
  Serial.print(";");
  Serial.print(temperatura_malteacao01);
  Serial.print(";");
  Serial.print(temperatura_malteacao02);
  Serial.print(";");
  Serial.print(temperatura_malteacao03);
  Serial.print(";");
  Serial.print(temperatura_moagem);
  Serial.print(";");
  Serial.print(temperatura_brassagem01);
  Serial.print(";");
  Serial.print(temperatura_brassagem02);
  Serial.print(";");
  Serial.print(temperatura_brassagem03);
  Serial.print(";");
  Serial.print(temperatura_fervura);
  Serial.print(";");
  Serial.print(temperatura_resfriamento01);
  Serial.print(";");
  Serial.print(temperatura_resfriamento02);
  Serial.print(";");
  Serial.print(temperatura_resfriamento03);
  Serial.print(";");
  Serial.print(temperatura_filtragem);
  Serial.print(";");
  Serial.print(temperatura_pasteurizacao);
  Serial.print(";");
  Serial.print(temperatura_envase);
  Serial.println(";");


  // /**
  // * Bloco do LDR5
  // */
  // leitura_ldr = analogRead(ldr_pin);
  // Serial.print(leitura_ldr);
  // Serial.print(";");
  // /**
  // * Bloco do TCRT5000
  // */
  // if(digitalRead(switch_pin) == LOW){
  // Serial.println(1);
  // }
  // else {
  // Serial.println(0);
delay(1000);
}
