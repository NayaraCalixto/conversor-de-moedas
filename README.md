<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
  <header>
    <h1> 📌 Conversor de Moedas com Java</h1>
  </header>
  <main>
    <div>
      <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white">
      <img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">
      <img src="https://img.shields.io/badge/Alura-13294B?style=for-the-badge&logo=data:image/svg+xml;base64,...">
    </div>
</main>
</body>
</html>

Este projeto foi desenvolvido como parte do desafio **PRATICANDO JAVA – CHALLENGE CONVERSOR DE MOEDAS**. O objetivo é criar uma aplicação em Java que permita ao usuário converter valores entre diferentes moedas, consumindo uma API de taxas de câmbio em tempo real.

## 🚀 Objetivo do Projeto

A aplicação possibilita ao usuário:
- **Escolher uma moeda de origem e uma moeda de destino** para a conversão.
- **Informar o valor a ser convertido**.
- **Consultar taxas de câmbio em tempo real** via API.
- **Exibir o valor convertido** com base na cotação atual.

## 📚 Tecnologias Utilizadas
- **Java**: Linguagem de programação da aplicação.
- **API ExchangeRate-API**: Serviço utilizado para obter taxas de câmbio atualizadas.
- **Bibliotecas**:
  - `HttpURLConnection`: Para requisições HTTP.
  - `Gson`: Para manipulação de JSON.
- **IDE**: IntelliJ IDEA, Visual Studio Code (ou sua IDE de preferência).

## 🌍 Sobre a ExchangeRate-API

A **ExchangeRate-API** é uma API pública que fornece taxas de câmbio atualizadas para diversas moedas. Ela permite a obtenção de taxas de câmbio em tempo real, facilitando conversões entre moedas diferentes. A API responde com um objeto JSON contendo as cotações mais recentes.

Exemplo de resposta da API:

![](assets/exemplo_json_api.png)

## 🔧 Funcionalidades
- 🔄 **Menu de conversão**:
  - Real para Dólar
  - Real para Euro
  - Real para Peso Mexicano
  - Real para Iene
  - Dólar para Real
  - Dólar para Euro
  - Dólar para Peso Mexicano
  - Dólar para Iene

- 🔎 **Consumo da API**: Requisição à API ExchangeRate-API para obter os valores de conversão.
- 📋 **Exibição do resultado**: Apresentação do valor convertido.
- 💾 **Registro de conversões**: Opcionalmente, salvar históricos de conversões realizadas.

## 🛠️ Passo a Passo do Funcionamento da Aplicação

O usuário é recebido com um menu de opções e escolher qual a conversão deseja fazer.

![](assets/menu.png)

O usuário informa qual tipo de conversão deseja fazer e o valor que deseja converter. No exemplo abaixo o usuário escolheu a opção "2", ou seja, converter de Real para Euro e passando o valor de R$ 2000,00 reias.

![](assets/interacao_usuario_01.png)

A aplicação faz uma requisição à **ExchangeRate-API**, buscando a taxa de câmbio atual entre as moedas selecionadas.
O programa aplica a taxa de câmbio ao valor inserido.
O valor convertido é mostrado ao usuário.

![](assets/interacao_usuario_02.png)

O usuário pode realizar outra conversão ou encerrar a aplicação. No caso, o usuário escolher a opção "9", para encerrar a aplicação. 

![](assets/interacao_usuario_03.png)

## ⚠️ Desafios do Challenge Conversor de Moedas

Este documento destaca as principais dificuldades enfrentadas no desafio **PRATICANDO JAVA – CHALLENGE CONVERSOR DE MOEDAS**, ajudando a entender pontos críticos e formas de superá-los.

## 🔹 Interação com o Usuário
- Criar um **menu intuitivo** e funcional no console.
- Validar entradas corretamente para evitar erros inesperados.

## 🔹 Consumo de API
- **Realizar requisições HTTP** corretamente para obter dados da API ExchangeRate-API.
- Lidar com possíveis falhas na resposta da API.

## 🔹 Manipulação de JSON
- Interpretar os **dados de taxa de câmbio** obtidos via JSON.
- Utilizar bibliotecas como **Gson** para extrair e processar as informações corretamente.

## 🔹 Lógica de Conversão
- Garantir **precisão nos cálculos** de conversão entre moedas.
- Exibir os resultados de forma clara e compreensível.

## 🔹 Tratamento de Erros
- Implementar verificações **try-catch** para capturar exceções.
- Exibir mensagens de erro úteis ao usuário.

## 🔹 Gerenciamento de Código
- Manter uma **estrutura organizada**, com classes e métodos bem definidos.
- Escrever um código limpo e fácil de manter.


## 📂 Como Executar
1. Clone o repositório do projeto:
   ```bash
   git clone https://github.com/NayaraCalixto/conversor-de-moedas

## 👨‍🏫 Instrutores
- Jacqueline Oliveira
- Paulo Silveira


## 🚀 Projeto do Curso Java One
Este projeto faz parte do desafio proposto no curso <strong>Java One</strong>, com o objetivo de consolidar os aprendizados iniciais em Java através da criação de um sistema prático e funcional.

