# Enterprise ERP

Este repositório contém o núcleo do projeto Enterprise ERP, um sistema de Planejamento de Recursos Empresariais modular em desenvolvimento para fins acadêmicos com Spring Boot e persistência robusta em banco de dados Oracle.

---

## 📌 Status do Desenvolvimento (Roadmap)

O ecossistema do ERP está sendo construído em fases estruturadas, garantindo que a infraestrutura e o modelo de negócios estejam alinhados com as melhores práticas de mercado corporativo.

### [Fase 0] - Inicialização da Infraestrutura (Concluído)
*   **Banco de Dados:** Oracle Database 21c (XE) rodando via Docker.
*   **Isolamento:** Configurado via Pluggable Database (PDB) no serviço `XEPDB1`.
*   **Segurança:** Credenciais locais isoladas em arquivo `.env` (não versionado).

### [Fase 1] - Modelagem e Mapeamento Base do Domínio (Em andamento)
*   [x] **Mapeamento da Entidade `Cliente`**
    *   Suporte a Pessoa Física e Jurídica gerenciado dinamicamente através de Enums (`TipoCliente`).
    *   Controle de ciclo de vida cadastral via Enum (`StatusCadastro`).
    *   Restrições explícitas de banco de dados (`nullable`, `unique`, tamanhos de campos VARCHAR2).
    *   Controle rígido do tamanho de documentos (`numeroDocumento` limitado a 14 caracteres).
    *   Estrutura de auditoria básica protegida contra modificações (`dataCadastro` com `updatable = false`).
    *   Geração de chaves primárias otimizada para o dialeto Oracle através de `@SequenceGenerator` dedicado (`seq_id_cliente`).
*   [x] **Mapeamento da Entidade `Produto`**
*   [ ] **Mapeamento da Entidade `Fornecedor`** *(Próximo passo)*

### [Fase 2] - Refatoração Arquitetural e Padrões DDD (Planejado)
*   [ ] **Introdução de *Value Objects*** (Isolamento de lógicas de negócio e validações auto-contidas, como GTIN e CPF/CNPJ).
*   [ ] **Definição de *Aggregate Roots* (Raízes de Agregação)** (Garantia de consistência transacional do ecossistema).

### [Fase 3] - Implementação das Camadas de Infraestrutura e CRUD (Planejado)
*   [ ] **Criação dos Repositórios** (`Spring Data JPA`).
*   [ ] **Camada de Serviço e DTOs** (Implementação das regras de aplicação e objetos de transferência de dados).
*   [ ] **Controladores REST** (Exposição dos endpoints da API para consumo externo).

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

Autor: Gustavo Dutra - 2026.