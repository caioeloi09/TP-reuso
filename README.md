# Projeto da disciplina Reutilização de Software
- Inicialmente projeto apenas com eleição presidencial em que houve a adição da possibilidade de segundo turno assim como novos tipos de eleições, sendo estendido para suportar municipais, estaduais e universitárias.

## Padrões de projeto:
- Factory Method
- Strategy

## Padrão de arquitetura:
- Model-View-Control

## Dependencias:

- [Java Developer Kit (JDK) 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Make

## Comandos make:

- `make` ou `make full`: Buildar + Executar
- `make build`: Buildar
- `make run`: Executar
- `make clean`: Limpa os arquivos `.class` gerados no build

## Como rodar:

- Na root do repositório use o comando `make` para buildar e executar o programa

## Utilização:

- O sistema já vem inicializado com alguns candidatos para cada tipo de eleição, sendo possivel visualizar nos arquivos .txt refente a cada eleição
- O sistema já vem com os dois gestores (de sessão e de candidaturas)
- O sistema já vem com todos os eleitores possíveis para utilizá-los basta checar o arquivo voterLoad.txt

No menu inicial para gerenciar candidatos e eleição siga pela opção 2:

- (1) User: emp , Password: 12345 -> Cadastro e remoção de candidatos da eleição
- (2) User: cert , Password: 54321 -> Inicialização/finalização da eleição (liberar pra poder votar) e mostrar o resultado ao final da eleição.

Além da senha de usuário é necessário a senha da eleição para completar operações relacionadas a gestão da eleição ou candidatos. Essa senha é a palavra password

Para votar também existe um eleitor com o título de eleitor nº 123456789012 que pode votar nos candidatos pré-cadastrados
