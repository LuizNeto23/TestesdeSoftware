void setup() {
  // put your setup code here, to run once:

}

void loop() {
  // put your main code here, to run repeatedly:

}#include <ESP8266WiFi.h>
const char* ssid     = "*********";   // Seu  ssid
const char* password = "***********"; // Sua  senha
float temp_celsius = 0;
float temp_fahrenheit = 0;
WiFiServer server(80);
void setup() {
  Serial.begin(115200);
  pinMode(A0, INPUT);   
  Serial.println();
  Serial.println();
  Serial.print("Conectado a ");
  Serial.println(ssid);
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi foi contectado");
  server.begin();
  Serial.println("Server Iniciado");
  Serial.println(WiFi.localIP());
}
void loop() {
  temp_celsius = (analogRead(A0) * 330.0) / 1023.0;   //Para converter valores analógicos em Celsius Temos 3,3 V em nossa placa e sabemos que a tensão de saída do LM35 varia em 10 mV a cada aumento / queda de grau Celsius. Portanto, (A0 * 3300/10) / 1023 = celsius
  temp_fahrenheit = celsius * 1.8 + 32.0;
  Serial.print("  Temperatura = ");
  Serial.print(temp_celsius);
  Serial.print(" Celsius, ");
  Serial.print(temp_fahrenheit);
  Serial.println(" Fahrenheit");

  WiFiClient client = server.available();
  client.println("HTTP/1.1 200 OK");
  client.println("Content-Type: text/html");
  client.println("Connection: close");  // a conexão será fechada após a conclusão da resposta
  client.println("Refresh: 10");  // atualiza a página após 10 segundos
  client.println();
  client.println("<!DOCTYPE HTML>");
  client.println("<html>");
  client.print("<p style='text-align: center;'><span style='font-size: x-large;'><strong>Termômetro digital</strong></span></p>");
  client.print("<p style='text-align: center;'><span style='color: #0000ff;'><strong style='font-size: large;'>Temperatura (*C)= ");
  client.println(temp_celsius);
  client.print("<p style='text-align: center;'><span style='color: #0000ff;'><strong style='font-size: large;'>Temperatura (F) = ");
  client.println(temp_fahrenheit);
  client.print("</p>");
  client.println("</html>");
  delay(5000);
}
