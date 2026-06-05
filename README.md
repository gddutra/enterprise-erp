# Enterprise ERP

Este repositório contém o núcleo do projeto Enterprise ERP. Atualmente, o projeto encontra-se na fase inicial de configuração de ambiente e infraestrutura básica (Etapa Zero).

## 🛠️ Status Atual: Inicialização da Infraestrutura

Nesta etapa, foi estruturado o ambiente conteinerizado para o banco de dados e as configurações iniciais de propriedades do Spring Boot.

* **Banco de Dados:** Oracle Database 21c (XE) rodando via Docker.
* **Isolamento:** Configurado via Pluggable Database (PDB) no serviço `XEPDB1`.
* **Segurança:** Credenciais locais isoladas em arquivo `.env` (não versionado).

---

## 🚀 Como Subir o Ambiente Local

### 1. Variáveis de Ambiente
Crie um arquivo `.env` na raiz do projeto com as suas credenciais:
```env
ORACLE_DB_MASTER_PASSWORD=sua_senha_mestra
ERP_DB_USER=erp_application
ERP_DB_PASSWORD=sua_senha_da_aplicacao
```
### 2. Subir o Banco (Docker)
Execute o comando na raiz do projeto:
```Bash
docker-compose up -d
```
### 3. Conexão com o Banco (DBeaver/Clients)
```
Host: localhost | Porta: 1521
Tipo: Service Name | Service Name: XEPDB1
Usuário/Senha: Definidos no seu .env
```
Desenvolvido por Gustavo Dutra - 2026.