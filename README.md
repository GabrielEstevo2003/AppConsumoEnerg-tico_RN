Objetivo do Aplicativo:
O principal objetivo do aplicativo é auxiliar o usuário a monitorar e estimar o consumo energético de seus aparelhos eletrônicos e eletrodomésticos.
Isso é alcançado através de:
Cálculo de Consumo: Calcular o consumo energético diário dos dispositivos cadastrados (em kWh/dia).
Contextualização Climática: Integrar a informação de consumo com o clima atual (temperatura) consultado em tempo real na API do OpenWeather.
Isso permite estimar variações no uso de dispositivos sensíveis ao clima (como ar-condicionado e aquecedores).

Estrutura da API (Backend Spring Boot):
O backend do projeto expõe dois conjuntos principais de endpoints REST, um para a gestão dos dispositivos e outro para a consulta do clima.

Url base da API: http://localhost:8080

Controller de Gestão de Dispositivos
1. Função de Salvar:
- Método: POST
- Endpoint: /dispositivos

2. Função de Atualizar:
- Método: PUT
- Endpoint: /dispositivos/{id}

3. Função de Listar:
- Método: GET
- Endpoint: /dispositivos

4. Função de ListarPorId:
- Método: GET
- Endpoint: /dispositivos/{id}

5. Função de ListarPorId:
- Método: DELETE
- Endpoint: /dispositivos/{id}

Controler OpenWeather (Previsão do Tempo)
1. Função de getTemp
- Método: GET
- Endpoint: /previsão/{city}
