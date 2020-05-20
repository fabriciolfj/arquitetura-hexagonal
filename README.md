### Arquitetura hexagonal

Segue abaixo umas das principais características da arquitetura hexagonal:
- foco nos requisitos de negócio inicialmente.
- uso adapters para entrada e saida de informação.
- domínio livre de frameworks (á um ponto de atenção nessa última afirmação referente ao uso de orm).
- Classes de serviço representção casos de uso (aqui se aplica-se Single of responsability S - solid.)
A proposta de uso dessa arquitetura inicia-se criando um package com nome do contexto e dentro do mesmo efetuar a quebra.

Exemplo:
- conta-corrente
	- Adapter
		- entrada
			- controller
		- saida
			- persistência
	- domain
		- classes de negócio
	- aplicacao
		- entrada
			- dtos
		- saida
			- dtos
				
		- classes service (que representa casos de uso, exemplo: EfetuarSaqueService, EfetuarDepositoService)
