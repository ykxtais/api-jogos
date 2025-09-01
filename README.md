# ⟢ API Jogos — Docker Compose na VM do Azure


## 1. Projeto
Este projeto simula a modernização tecnológica da empresa “DimDim”, conforme a prova de DevOps Tools & Cloud Computing.

O objetivo é containerizar uma aplicação de portfólio (API Jogos em Java) e o banco de dados PostgreSQL,
orquestrando tudo com Docker Compose.
Isso garante ambientes padronizados, escalabilidade e um processo de deploy contínuo.

**Aplicação escolhida**: API de Gerenciamento de Jogos (CRUD).

## 2. Arquitetura

| Arquitetura Anterior | Arquitetura Atual (Docker Compose) |
|:--------------------------------------------:|:------------------------------------------------------:|
| A aplicação roda como java -jar (ou via IDE) diretamente no host. O banco PostgreSQL também é configuradono host (ou serviço externo). O deploy é manual, sujeito a variações de ambiente. | Dois contêineres: api-jogos (aplicação) e postgres-dimdim (banco), na mesma rede bridge. O banco usa volume para persistência e healthcheck; a aplicação roda como usuário não-root. Exposição externa via mapeamento de porta do host. |
| <img src="https://github.com/user-attachments/assets/a6860a30-2c60-4d6a-90d8-0f2f3167c97a" width="420" alt="antes" /> | <img src="https://github.com/user-attachments/assets/c73c9388-ab69-4009-abe8-ab70f9ae13cb" width="420" alt="depois" /> |


## 3. Tecnologias Utilizadas

- Java 17, Spring Boot
- PostgreSQL 16
- Gradle
- Docker + Docker Compose
- Git e Nano

## 4. Pré-requisitos

- Uma VM Linux com:
  - Docker + Docker Compose
  - Git
- Portas 8080, 5000 e 22 liberadas

## 5. Como Executar

### 5.1 Clonar o Repositório
```
git clone https://github.com/ykxtais/api-jogos.git
cd api-jogos
```

### 5.2 Subir
```
docker compose up -d --build
```
  - `--build` força a reconstrução da imagem da aplicação (útil para caso tenha alterações no código).
  - `-d` roda os contêineres em segundo plano.
  
### 5.3 Teste

- Dentro da VM: `curl http://localhost:8080/jogos`
- No Navegador (Swagger): `http://<ip>:8080/swagger-ui/index.html`

## 6. Comandos essenciais do Docker Compose

- `docker compose up -d` Cria (se necessário) e inicia todos os serviços do docker-compose.yml, constrói a imagem se não existir.
  - `docker compose up -d --build` Força (re)build da imagem (caso tenha ou não alterações no código), depois cria e inicia.
- `docker compose ps` Lista o status dos serviços do projeto.
- `docker compose down` Para e remove os containers e as redes do projeto — mantém os dados do banco.
  - `docker compose down -v` Além do acima, remove os volumes do projeto (nomeados e anônimos) — apaga os dados do banco.
- `docker compose logs [aplicação]` - Mostra os logs do serviço em tempo real.

## 7. Troubleshooting

- Conexão ao banco falhando
  - Confirme DB_HOST=postgres-dimdim;
  - Confira logs: docker compose logs -f postgres-dimdim.
- Não abre no navegador
  - Verifique se passou o IP em `http://<ip>:8080/swagger-ui/index.html` corretamente;
  - Verifique que as porta `8080` esteja abertas;
  - Certifique-se de subir os contêineres `docker compose up -d` e que estão "Up" `docker compose ps`.

#

## ⟢ Equipe
 
> Iris Tavares Alves — 557728 </br>
> Taís Tavares Alves — 557553 
  
