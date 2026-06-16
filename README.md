# Enterprise ERP

Este repositório contém o núcleo do projeto Enterprise ERP, um sistema de Planejamento de Recursos Empresariais modular em desenvolvimento com Spring Boot e persistência robusta em banco de dados Oracle.

---

## 🛠️ Gestão do Projeto e Roadmap

O escopo de engenharia, requisitos de negócio e decisões arquiteturais deste ecossistema são mapeados e rastreados através do GitHub Issues.

A evolução das entregas (infraestrutura, modelagem do domínio, refatoração DDD e camadas de aplicação) pode ser acompanhada diretamente no painel de tarefas.

* 📋 **Roadmap técnico e tarefas:** [Issues / Quadro de Tarefas](./issues)

---

## 🚀 Como Subir o Ambiente Local

### 1. Variáveis de Ambiente
Na raiz do seu projeto (mesmo nível do arquivo `pom.xml`), crie um arquivo chamado exatamente **`.env`** e preencha-o com as suas credenciais locais:
```env
ORACLE_DB_MASTER_PASSWORD=sua_senha_mestra
ERP_DB_USER=erp_application
ERP_DB_PASSWORD=sua_senha_da_aplicacao
```

### 2. Configurando a leitura do `.env` no IntelliJ IDEA
O Spring Boot não injeta arquivos `.env` nativamente de forma automática. Para que a aplicação inicialize com sucesso lendo as variáveis do arquivo, siga um dos procedimentos abaixo no seu IntelliJ:

#### **Opção A: Utilizando o Plugin EnvFile (Recomendado)**
1. Instale o plugin **EnvFile** através do Marketplace do IntelliJ (*Settings > Plugins*).
2. No menu superior direito, clique na caixinha de configurações de inicialização da aplicação (*Run/Debug Configurations*) e selecione **Edit Configurations...**.
3. Na aba **EnvFile**, marque a opção **Enable EnvFile**.
4. Clique no ícone de **`+`**, selecione **.env file** e aponte para o arquivo `.env` criado na raiz do projeto.
5. Clique em **Apply** e dê **OK**.

#### **Opção B: Configuração Nativa via Variáveis de Ambiente**
1. No menu superior direito, clique em **Edit Configurations...**.
2. No campo **Environment variables**, clique no ícone de pasta/lápis para editar.
3. Adicione manualmente as chaves e os respectivos valores configurados no seu arquivo `.env`:
    * `ERP_DB_USER`
    * `ERP_DB_PASSWORD`
4. Clique em **Apply** e dê **OK**.

### 3. Subir o Banco (Docker)
Execute o comando na raiz do projeto para iniciar o container do Oracle XE:
```bash
docker-compose up -d
```

### 4. Conexão com o Banco (DBeaver/Clients)
Para se conectar diretamente à instância plugável do banco de dados, utilize as seguintes credenciais no seu client SQL:
```text
Host: localhost | Porta: 1521
Tipo: Service Name | Service Name: XEPDB1
Usuário/Senha: Definidos no seu .env (erp_application)
```

---

Autor: Gustavo Dutra.