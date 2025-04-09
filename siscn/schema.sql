--
-- ER/Studio Data Architect SQL Code Generation
-- Project :      Sisct - Cadastro Nacional.DM1
--
-- Date Created : Thursday, March 27, 2025 17:20:58
-- Target DBMS : Oracle 18c
--

-- 
-- TABLE: RL_ARQUIVOS 
--

CREATE TABLE RL_ARQUIVOS(
    PK_ARQUIVOS             NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    NU_DIAS_VALIDADE        NUMBER(38, 0),
    DT_VALIDADE             DATE,
    DS_ARQUIVO_URL          VARCHAR2(400)    NOT NULL,
    DS_COMPLEMENTO          VARCHAR2(200)    NOT NULL,
    PK_CADASTRO_NACIONAL    NUMBER(38, 0)    NOT NULL,
    PK_TIPO_ARQUIVO         NUMBER(38, 0)    NOT NULL,
    ST_ARQUIVO_ATIVO        CHAR(1)          NOT NULL,
    DT_ATUALIZACAO          TIMESTAMP(6)     NOT NULL,
    CONSTRAINT PK3 PRIMARY KEY (PK_ARQUIVOS)
)
;
COMMENT ON COLUMN RL_ARQUIVOS.PK_ARQUIVOS IS 'Chave primária autoincrementada que identifica unicamente cada arquivo. Exemplo: 1, 2, 3... (Sequencial único)';
COMMENT ON COLUMN RL_ARQUIVOS.NU_DIAS_VALIDADE IS 'Número de dias que o arquivo permanece válido a partir da data de upload. Exemplo: 365 (1 ano de validade)';
COMMENT ON COLUMN RL_ARQUIVOS.DT_VALIDADE IS 'Data de expiração da validade do arquivo no formato YYYY-MM-DD. Exemplo: 2025-12-31 (Calculada automaticamente quando informado NU_DIAS_VALIDADE)';
COMMENT ON COLUMN RL_ARQUIVOS.DS_ARQUIVO_URL IS 'Caminho completo ou URL de acesso ao arquivo no sistema. Exemplo: "/documentos/certidoes/CNPJ_12345678901234.pdf" (Obrigatório)';
COMMENT ON COLUMN RL_ARQUIVOS.DS_COMPLEMENTO IS 'Descrição complementar ou observações sobre o arquivo. Exemplo: "Certidão negativa de débitos trabalhistas" (Obrigatório)';
COMMENT ON COLUMN RL_ARQUIVOS.PK_CADASTRO_NACIONAL IS 'Chave estrangeira que relaciona o arquivo ao cadastro nacional. Exemplo: 42 (ID do cadastro vinculado)';
COMMENT ON COLUMN RL_ARQUIVOS.PK_TIPO_ARQUIVO IS 'Chave estrangeira que identifica o tipo de arquivo conforme TB_TIPO_ARQUIVOS. Exemplo: 3 (ID do tipo "Certidão Negativa")';
COMMENT ON COLUMN RL_ARQUIVOS.ST_ARQUIVO_ATIVO IS 'Status que indica se o arquivo está ativo (S) ou inativo (N). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN RL_ARQUIVOS.DT_ATUALIZACAO IS 'Data e hora da última atualização do registro no formato TIMESTAMP. Exemplo: 2025-03-28 15:22:10.123456 (Obrigatório)';

-- Comentário sobre a tabela
COMMENT ON TABLE RL_ARQUIVOS IS 'Tabela que armazena todos os arquivos/documentos digitais vinculados aos cadastros nacionais, com informações de validade e tipo';


-- 
-- TABLE: RL_ATENDIMENTO 
--

CREATE TABLE RL_ATENDIMENTO(
    PK_ATENDIMENTO          NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    NO_NOME                 VARCHAR2(100)    NOT NULL,
    ST_ATENDIMENTO_ATIVO    CHAR(1)          NOT NULL,
    DT_ATUALIZACAO          TIMESTAMP(6)     NOT NULL,
    PK_CADASTRO_NACIONAL    NUMBER(38, 0)    NOT NULL,
    PK_TIPO_ATENDIMENTO     NUMBER(38, 0)    NOT NULL,
    CONSTRAINT PK14 PRIMARY KEY (PK_ATENDIMENTO)
)
;
COMMENT ON COLUMN RL_ATENDIMENTO.PK_ATENDIMENTO IS 'Chave primária autoincrementada que identifica cada registro de atendimento. Exemplo: 1001, 1002, 1003... (Valor único sequencial)';
COMMENT ON COLUMN RL_ATENDIMENTO.NO_NOME IS 'Nome descritivo do tipo de atendimento oferecido. Exemplo: "Acolhimento Institucional para Crianças" (Obrigatório, máx. 100 caracteres)';
COMMENT ON COLUMN RL_ATENDIMENTO.ST_ATENDIMENTO_ATIVO IS 'Status que indica se o atendimento está ativo (S) ou inativo (N). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN RL_ATENDIMENTO.DT_ATUALIZACAO IS 'Data e hora da última atualização no formato TIMESTAMP. Exemplo: 2025-03-28 09:45:30.123456 (Obrigatório)';
COMMENT ON COLUMN RL_ATENDIMENTO.PK_CADASTRO_NACIONAL IS 'Chave estrangeira que vincula ao cadastro nacional. Exemplo: 42 (ID da entidade prestadora)';
COMMENT ON COLUMN RL_ATENDIMENTO.PK_TIPO_ATENDIMENTO IS 'Chave estrangeira que classifica o atendimento conforme TB_TIPO_ATENDIMENTO. Exemplo: 5 (ID para "Atendimento a Dependentes Químicos")';

-- Comentário sobre a tabela
COMMENT ON TABLE RL_ATENDIMENTO IS 'Tabela que registra os tipos de atendimentos/serviços oferecidos por cada entidade cadastrada, com informações de status e vínculo';



-- 
-- TABLE: RL_CONTATOS 
--

CREATE TABLE RL_CONTATOS(
    PK_RLCONTATOS           NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    CO_CONTATO              VARCHAR2(200)    NOT NULL,
    PK_CADASTRO_NACIONAL    NUMBER(38, 0)    NOT NULL,
    PK_TIPO_CONTATO         NUMBER(38, 0)    NOT NULL,
    ST_CONTATO_ATIVO        CHAR(1)          NOT NULL,
    DT_ATUALIZACAO          TIMESTAMP(6)     NOT NULL,
    CONSTRAINT PK9 PRIMARY KEY (PK_RLCONTATOS)
)
;
COMMENT ON COLUMN RL_CONTATOS.PK_RLCONTATOS IS 'Chave primária autoincrementada que identifica cada contato cadastrado. Exemplo: 500, 501, 502... (Valor único sequencial)';
COMMENT ON COLUMN RL_CONTATOS.CO_CONTATO IS 'Informação completa do contato (telefone, email, etc.). Exemplo: "(61) 99999-8888" ou "contato@entidade.org.br" (Obrigatório, máx. 200 caracteres)';
COMMENT ON COLUMN RL_CONTATOS.PK_CADASTRO_NACIONAL IS 'Chave estrangeira que vincula o contato a um cadastro nacional. Exemplo: 42 (ID da entidade relacionada)';
COMMENT ON COLUMN RL_CONTATOS.PK_TIPO_CONTATO IS 'Chave estrangeira que classifica o tipo de contato conforme TB_TIPO_CONTATO. Exemplo: 1 (Telefone Fixo), 2 (Celular), 3 (E-mail)';
COMMENT ON COLUMN RL_CONTATOS.ST_CONTATO_ATIVO IS 'Status que indica se o contato está ativo (S) ou inativo (N). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN RL_CONTATOS.DT_ATUALIZACAO IS 'Data e hora da última atualização no formato TIMESTAMP. Exemplo: 2025-03-28 14:15:20.123456 (Obrigatório)';

-- Comentário sobre a tabela
COMMENT ON TABLE RL_CONTATOS IS 'Tabela que armazena todos os contatos (telefones, emails, etc.) associados às entidades cadastradas, com classificação por tipo';

-- 
-- TABLE: RL_EQUIPE_TECNICA 
--

CREATE TABLE RL_EQUIPE_TECNICA(
    PK_EQUIPE_TECNICA          NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    NO_NOME                    VARCHAR2(200)    NOT NULL,
    NU_CARGA_HORARIA           NUMBER(38, 0)    NOT NULL,
    ST_EQUIPE_TECNICA_ATIVO    CHAR(1)          NOT NULL,
    DT_ATUALIZACAO             TIMESTAMP(6)     NOT NULL,
    PK_CADASTRO_NACIONAL       NUMBER(38, 0)    NOT NULL,
    PK_PROFISSAO               NUMBER(38, 0)    NOT NULL,
    PK_VINCULO                 NUMBER(38, 0)    NOT NULL,
    CONSTRAINT PK18 PRIMARY KEY (PK_EQUIPE_TECNICA)
)
;

COMMENT ON COLUMN RL_EQUIPE_TECNICA.PK_EQUIPE_TECNICA IS 'Chave primária autoincrementada que identifica cada membro da equipe técnica. Exemplo: 150, 151, 152... (Valor único sequencial)';
COMMENT ON COLUMN RL_EQUIPE_TECNICA.NO_NOME IS 'Nome completo do profissional da equipe técnica. Exemplo: "Ana Carolina Silva Santos" (Obrigatório, máx. 200 caracteres)';
COMMENT ON COLUMN RL_EQUIPE_TECNICA.NU_CARGA_HORARIA IS 'Carga horária semanal do profissional em horas. Exemplo: 40 (para 40 horas semanais) (Obrigatório)';
COMMENT ON COLUMN RL_EQUIPE_TECNICA.ST_EQUIPE_TECNICA_ATIVO IS 'Status que indica se o profissional está ativo (S) ou inativo (N) na equipe. Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN RL_EQUIPE_TECNICA.DT_ATUALIZACAO IS 'Data e hora da última atualização no formato TIMESTAMP. Exemplo: 2025-03-28 16:30:45.123456 (Obrigatório)';
COMMENT ON COLUMN RL_EQUIPE_TECNICA.PK_CADASTRO_NACIONAL IS 'Chave estrangeira que vincula o profissional a um cadastro nacional. Exemplo: 42 (ID da entidade relacionada)';
COMMENT ON COLUMN RL_EQUIPE_TECNICA.PK_PROFISSAO IS 'Chave estrangeira que identifica a profissão conforme TB_PROFISSAO. Exemplo: 5 (para "Psicólogo")';
COMMENT ON COLUMN RL_EQUIPE_TECNICA.PK_VINCULO IS 'Chave estrangeira que identifica o tipo de vínculo empregatício conforme TB_VINCULO. Exemplo: 2 (para "CLT")';

-- Comentário sobre a tabela
COMMENT ON TABLE RL_EQUIPE_TECNICA IS 'Tabela que registra os profissionais que compõem a equipe técnica das entidades, com informações de formação, carga horária e vínculo';


-- 
-- TABLE: RL_MAPA_VAGAS 
--

CREATE TABLE RL_MAPA_VAGAS(
    PK_MAPA_VAGAS            NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    NU_DISPONIBILIDADE       NUMBER(38, 0)    NOT NULL,
    NU_PUBLICO               NUMBER(38, 0)    NOT NULL,
    ST_MAPA_VAGAS_ATIVO      CHAR(1)          NOT NULL,
    DT_ATUALIZACAO           TIMESTAMP(6)     NOT NULL,
    PK_TIPO_FINANCIAMENTO    NUMBER(38, 0)    NOT NULL,
    PK_CADASTRO_NACIONAL     NUMBER(38, 0)    NOT NULL,
    CONSTRAINT PK16 PRIMARY KEY (PK_MAPA_VAGAS)
)
;
COMMENT ON COLUMN RL_MAPA_VAGAS.PK_MAPA_VAGAS IS 'Chave primária autoincrementada que identifica cada registro de mapeamento de vagas. Exemplo: 75, 76, 77... (Valor único sequencial)';
COMMENT ON COLUMN RL_MAPA_VAGAS.NU_DISPONIBILIDADE IS 'Quantidade total de vagas disponíveis para o tipo de financiamento. Exemplo: 20 (indica 20 vagas disponíveis) (Obrigatório)';
COMMENT ON COLUMN RL_MAPA_VAGAS.NU_PUBLICO IS 'Quantidade de pessoas atendidas nas vagas disponíveis. Exemplo: 15 (indica 15 vagas ocupadas) (Obrigatório)';
COMMENT ON COLUMN RL_MAPA_VAGAS.ST_MAPA_VAGAS_ATIVO IS 'Status que indica se o registro de vagas está ativo (S) ou inativo (N). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN RL_MAPA_VAGAS.DT_ATUALIZACAO IS 'Data e hora da última atualização no formato TIMESTAMP. Exemplo: 2025-03-28 10:15:30.123456 (Obrigatório)';
COMMENT ON COLUMN RL_MAPA_VAGAS.PK_TIPO_FINANCIAMENTO IS 'Chave estrangeira que identifica o tipo de financiamento conforme TB_TIPO_FINANCIAMENTO. Exemplo: 3 (para "Recursos Próprios")';
COMMENT ON COLUMN RL_MAPA_VAGAS.PK_CADASTRO_NACIONAL IS 'Chave estrangeira que vincula o mapa de vagas a um cadastro nacional. Exemplo: 42 (ID da entidade relacionada)';

-- Comentário sobre a tabela
COMMENT ON TABLE RL_MAPA_VAGAS IS 'Tabela que registra a disponibilidade e ocupação de vagas por tipo de financiamento para cada entidade cadastrada';


-- 
-- TABLE: RL_RESPOSTA_SELECIONADA 
--

CREATE TABLE RL_RESPOSTA_SELECIONADA(
    PK_RESPOSTA_SELECIONADA          NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    DS_COMPLEMENTO                   VARCHAR2(200),
    ST_RESPOSTA_SELECIONADA_ATIVO    CHAR(1)          NOT NULL,
    DT_ATUALIZACAO                   TIMESTAMP(6)     NOT NULL,
    PK_RESPOSTA                      NUMBER(38, 0)    NOT NULL,
    PK_CADASTRO_NACIONAL             NUMBER(38, 0)    NOT NULL,
    CONSTRAINT PK13 PRIMARY KEY (PK_RESPOSTA_SELECIONADA)
)
;
COMMENT ON COLUMN RL_RESPOSTA_SELECIONADA.PK_RESPOSTA_SELECIONADA IS 'Chave primária autoincrementada que identifica cada resposta selecionada. Exemplo: 200, 201, 202... (Valor único sequencial)';
COMMENT ON COLUMN RL_RESPOSTA_SELECIONADA.DS_COMPLEMENTO IS 'Texto complementar à resposta padrão, quando necessário. Exemplo: "Atendemos apenas nos meses de julho e dezembro" (Opcional, máx. 200 caracteres)';
COMMENT ON COLUMN RL_RESPOSTA_SELECIONADA.ST_RESPOSTA_SELECIONADA_ATIVO IS 'Status que indica se a resposta está ativa (S) ou inativa (N). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN RL_RESPOSTA_SELECIONADA.DT_ATUALIZACAO IS 'Data e hora da última atualização no formato TIMESTAMP. Exemplo: 2025-03-28 11:45:15.123456 (Obrigatório)';
COMMENT ON COLUMN RL_RESPOSTA_SELECIONADA.PK_RESPOSTA IS 'Chave estrangeira que vincula à resposta padrão na tabela TB_RESPOSTA. Exemplo: 45 (ID da resposta "Sim, parcialmente")';
COMMENT ON COLUMN RL_RESPOSTA_SELECIONADA.PK_CADASTRO_NACIONAL IS 'Chave estrangeira que associa a resposta a um cadastro nacional. Exemplo: 42 (ID da entidade relacionada)';

-- Comentário sobre a tabela
COMMENT ON TABLE RL_RESPOSTA_SELECIONADA IS 'Tabela que armazena as respostas selecionadas para perguntas do cadastro, permitindo complementos específicos por entidade';

-- 
-- TABLE: TB_CADASTRO_NACIONAL 
--

CREATE TABLE TB_CADASTRO_NACIONAL(
    PK_CADASTRO_NACIONAL            NUMBER(38, 0)    GENERATED BY DEFAULT AS IDENTITY (START WITH 1 INCREMENT BY 1 CACHE 1 NOCYCLE),
    NU_CNPJ                         CHAR(14)         NOT NULL,
    NU_FILIAIS                      NUMBER(38, 0)    NOT NULL,
    NO_FANTASIA                     VARCHAR2(200)    NOT NULL,
    NO_RAZAO_SOCIAL                 VARCHAR2(200)    NOT NULL,
    CO_CNAE_PRINCIPAL               VARCHAR2(20)     NOT NULL,
    CO_CNAE_SECUNDARIO              VARCHAR2(20)     NOT NULL,
    VL_RECEITA_BRUTA                NUMBER(18, 2)    NOT NULL,
    TP_FINANCIAMENTO_UNIAO          CHAR(1)          NOT NULL,
    TP_FINANCIAMENTO_ESTADO         CHAR(1)          NOT NULL,
    TP_FINANCIAMENTO_MUNICIPIO      CHAR(1)          NOT NULL,
    NU_MESES_PROJETO                NUMBER(38, 0),
    TP_POSSUI_CEBAS                 CHAR(1)          NOT NULL,
    DT_CEBAS_INICIO                 DATE             NOT NULL,
    DT_CEBAS_FINAL                  DATE             NOT NULL,
    TP_REQUERIMENTO_CEBAS           CHAR(1)          NOT NULL,
    NU_CEBAS_ANO_PROTOCOLO          NUMBER(38, 0),
    NU_CEBAS_PROTOCOLO              NUMBER(38, 0),
    TP_CUMPRE_DISPOSITIVOS          CHAR(1)          NOT NULL,
    NU_TOTAL_VAGAS                  NUMBER(38, 0),
    TP_POSSUI_INS_CONS_MUNICIPAL    CHAR(1)          NOT NULL,
    TP_CONSELHO_INSCRITO            CHAR(1)          NOT NULL,
    TP_POSSUI_INS_CONS_ESTADUAL     CHAR(1)          NOT NULL,
    NO_CONSELHO_ESTADUAL            VARCHAR2(200)    NOT NULL,
    TP_POSSUI_RECON_PUBLICA         CHAR(1)          NOT NULL,
    TP_POSSUI_RECON_PUBLICA_QUAL    CHAR(1),
    TP_PERIODICIDADE_CAPACITACAO    CHAR(1)          NOT NULL,
    TP_ACOLHIMENTO_PROVISORIO       CHAR(1)          NOT NULL,
    TP_COMUN_TERAPEUTICA            CHAR(1)          NOT NULL,
    TP_CAPACIDADE                   CHAR(1)          NOT NULL,
    TP_ACESSO_PUBLICO_ALVO          CHAR(1)          NOT NULL,
    TP_ARTICULACAO                  CHAR(1)          NOT NULL,
    DS_ARTICULACAO                  VARCHAR2(200)    NOT NULL,
    TP_POSSUI_QUADRO_TECNICO        CHAR(1)          NOT NULL,
    TP_GRATUITO                     CHAR(1)          NOT NULL,
    DS_CUSTEIO                      VARCHAR2(200)    NOT NULL,
    TP_PERIODICIDADE_ATIVIDADES     CHAR(1)          NOT NULL,
    DS_PERIODICIDADE_ATIVIDADES     VARCHAR2(200)    NOT NULL,
    TP_CONTROLE_PUBLICO_ALVO        CHAR(1)          NOT NULL,
    TP_POSSUI_SICAF                 CHAR(1)          NOT NULL,
    NU_STATUS                       NUMBER(38, 0)    NOT NULL,
    ST_CADASTRO_NACIONAL_ATIVO      CHAR(1)          NOT NULL,
    DT_ATUALIZACAO                  TIMESTAMP(6)     NOT NULL,
    CONSTRAINT PK1 PRIMARY KEY (PK_CADASTRO_NACIONAL)
)
;
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.PK_CADASTRO_NACIONAL IS 'Chave primária autoincrementada do cadastro. Exemplo: 1, 2, 3... (Identificador único)';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.NU_CNPJ IS 'CNPJ da entidade no formato 14 dígitos. Exemplo: 12345678000190 (Sem pontuação)';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.NU_FILIAIS IS 'Número de filiais da entidade. Exemplo: 3 (Zero para matriz única)';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.NO_FANTASIA IS 'Nome fantasia da entidade. Exemplo: "Lar da Criança Feliz"';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.NO_RAZAO_SOCIAL IS 'Razão social completa. Exemplo: "Associação Beneficente Esperança"';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.CO_CNAE_PRINCIPAL IS 'Código CNAE principal. Exemplo: 88123 (Atividades de assistência social)';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.CO_CNAE_SECUNDARIO IS 'Código CNAE secundário. Exemplo: 85339 (Educação infantil)';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.VL_RECEITA_BRUTA IS 'Receita bruta anual. Exemplo: 500000.00 (R$ 500 mil com 2 decimais)';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.TP_POSSUI_CEBAS IS 'Possui certificação CEBAS? (S/N). Exemplo: "S"';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.DT_CEBAS_INICIO IS 'Data inicial da validade CEBAS. Exemplo: 2024-01-01';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.DT_CEBAS_FINAL IS 'Data final da validade CEBAS. Exemplo: 2026-12-31';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.NU_CEBAS_PROTOCOLO IS 'Número do protocolo CEBAS. Exemplo: 123456789';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.NU_TOTAL_VAGAS IS 'Total de vagas ofertadas. Exemplo: 50';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.TP_GRATUITO IS 'Serviço é gratuito? (S/N). Exemplo: "S"';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.DS_CUSTEIO IS 'Descrição das fontes de custeio. Exemplo: "Doações e convênios municipais"';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.NU_STATUS IS 'Status do cadastro (1=Ativo, 2=Pendente, 3=Inativo). Exemplo: 1';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.ST_CADASTRO_NACIONAL_ATIVO IS 'Registro ativo no sistema? (S/N). Exemplo: "S"';
COMMENT ON COLUMN TB_CADASTRO_NACIONAL.DT_ATUALIZACAO IS 'Data/hora da última atualização. Exemplo: 2025-03-28 14:30:00';

COMMENT ON TABLE TB_CADASTRO_NACIONAL IS 'Tabela principal que armazena os dados cadastrais das entidades do sistema nacional';

-- 
-- TABLE: TB_DILIGENCIA 
--

CREATE TABLE TB_DILIGENCIA(
    PK_DILIGENCIA           NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    DT_ENVIO                DATE,
    DT_ULTIMA_ALTERACAO     DATE             NOT NULL,
    DT_INICIO_DILIGENCIA    DATE             NOT NULL,
    DS_DESCRICAO            VARCHAR2(800)    NOT NULL,
    PK_CADASTRO_NACIONAL    NUMBER(38, 0)    NOT NULL,
    CONSTRAINT PK25 PRIMARY KEY (PK_DILIGENCIA)
)
;
COMMENT ON COLUMN TB_DILIGENCIA.PK_DILIGENCIA IS 'Chave primária autoincrementada que identifica cada diligência. Exemplo: 1, 2, 3... (Valor único sequencial)';
COMMENT ON COLUMN TB_DILIGENCIA.DT_ENVIO IS 'Data de envio da diligência no formato YYYY-MM-DD. Exemplo: 2025-03-01 (Opcional - preenchida quando enviada)';
COMMENT ON COLUMN TB_DILIGENCIA.DT_ULTIMA_ALTERACAO IS 'Data da última modificação no formato YYYY-MM-DD. Exemplo: 2025-03-05 (Obrigatório)';
COMMENT ON COLUMN TB_DILIGENCIA.DT_INICIO_DILIGENCIA IS 'Data de início do prazo para resposta no formato YYYY-MM-DD. Exemplo: 2025-03-02 (Obrigatório)';
COMMENT ON COLUMN TB_DILIGENCIA.DS_DESCRICAO IS 'Descrição detalhada da diligência. Exemplo: "Enviar documentação comprobatória de regularidade fiscal" (Obrigatório, máx. 800 caracteres)';
COMMENT ON COLUMN TB_DILIGENCIA.PK_CADASTRO_NACIONAL IS 'Chave estrangeira que vincula a diligência a um cadastro. Exemplo: 42 (ID da entidade relacionada)';

-- Comentário sobre a tabela
COMMENT ON TABLE TB_DILIGENCIA IS 'Tabela que registra as diligências (solicitações de informação/documentação) realizadas sobre os cadastros';



-- 
-- TABLE: TB_ENDERECO 
--

CREATE TABLE TB_ENDERECO(
    PK_ENDERECO             NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    DS_LOGRADOURO           VARCHAR2(200)    NOT NULL,
    DS_COMPLEMENTO          VARCHAR2(200)    NOT NULL,
    NO_BAIRRO               VARCHAR2(100)    NOT NULL,
    NU_NUMERO               VARCHAR2(50)     NOT NULL,
    NU_CEP                  VARCHAR2(50)     NOT NULL,
    DT_ATUALIZACAO          TIMESTAMP(6)     NOT NULL,
    ST_ENDERECO_ATIVO       CHAR(1),
    PK_CADASTRO_NACIONAL    NUMBER(38, 0)    NOT NULL,
    CONSTRAINT PK4 PRIMARY KEY (PK_ENDERECO)
)
;
COMMENT ON COLUMN TB_ENDERECO.PK_ENDERECO IS 'Chave primária autoincrementada que identifica cada endereço. Exemplo: 25, 26, 27... (Valor único sequencial)';
COMMENT ON COLUMN TB_ENDERECO.DS_LOGRADOURO IS 'Nome do logradouro. Exemplo: "Avenida das Nações" (Obrigatório, máx. 200 caracteres)';
COMMENT ON COLUMN TB_ENDERECO.DS_COMPLEMENTO IS 'Complemento do endereço. Exemplo: "Bloco B, Sala 201" (Obrigatório, máx. 200 caracteres)';
COMMENT ON COLUMN TB_ENDERECO.NO_BAIRRO IS 'Nome do bairro. Exemplo: "Centro" (Obrigatório, máx. 100 caracteres)';
COMMENT ON COLUMN TB_ENDERECO.NU_NUMERO IS 'Número do endereço. Exemplo: "123" ou "S/N" (Obrigatório, máx. 50 caracteres)';
COMMENT ON COLUMN TB_ENDERECO.NU_CEP IS 'CEP no formato XXXXX-XXX. Exemplo: "70000-000" (Obrigatório)';
COMMENT ON COLUMN TB_ENDERECO.DT_ATUALIZACAO IS 'Data e hora da última atualização no formato TIMESTAMP. Exemplo: 2025-03-28 15:45:00.123456 (Obrigatório)';
COMMENT ON COLUMN TB_ENDERECO.ST_ENDERECO_ATIVO IS 'Status que indica se o endereço está ativo (S) ou inativo (N). Exemplo: "S" (Opcional)';
COMMENT ON COLUMN TB_ENDERECO.PK_CADASTRO_NACIONAL IS 'Chave estrangeira que vincula o endereço a um cadastro nacional. Exemplo: 42 (ID da entidade relacionada)';

-- Comentário sobre a tabela
COMMENT ON TABLE TB_ENDERECO IS 'Tabela que armazena os endereços das entidades cadastradas, permitindo múltiplos endereços por entidade';

-- 
-- TABLE: TB_ENTIDADE_COMPLEMENTO 
--

CREATE TABLE TB_ENTIDADE_COMPLEMENTO(
    PK_CADASTRO_NACIONAL          NUMBER(38, 0)    NOT NULL,
    TP_DOZE_PASSOS                CHAR(1)          NOT NULL,
    DS_DOZE_PASSOS                VARCHAR2(200)    NOT NULL,
    TP_APOIO_DOZE_PASSOS          CHAR(1)          NOT NULL,
    DS_APOIO_DOZE_PASSOS          VARCHAR2(200)    NOT NULL,
    TP_ATENDIMENTO_PSICOSOCIAL    CHAR(1)          NOT NULL,
    DS_ATENDIMENTO_PSICOSOCIAL    VARCHAR2(200)    NOT NULL,
    TP_ATIV_RESSOCIALI            CHAR(1)          NOT NULL,
    TP_POSSUI_PARCERIAS           CHAR(1)          NOT NULL,
    CONSTRAINT PK22 PRIMARY KEY (PK_CADASTRO_NACIONAL)
)
;
COMMENT ON COLUMN TB_ENTIDADE_COMPLEMENTO.PK_CADASTRO_NACIONAL IS 'Chave primária que referencia o cadastro nacional. Exemplo: 42 (ID da entidade relacionada)';
COMMENT ON COLUMN TB_ENTIDADE_COMPLEMENTO.TP_DOZE_PASSOS IS 'Adota metodologia dos 12 passos? (S=Sim, N=Não). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN TB_ENTIDADE_COMPLEMENTO.DS_DOZE_PASSOS IS 'Descrição da aplicação dos 12 passos. Exemplo: "Realizamos encontros semanais seguindo a metodologia" (Obrigatório)';
COMMENT ON COLUMN TB_ENTIDADE_COMPLEMENTO.TP_APOIO_DOZE_PASSOS IS 'Oferece apoio aos 12 passos? (S=Sim, N=Não). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN TB_ENTIDADE_COMPLEMENTO.DS_APOIO_DOZE_PASSOS IS 'Descrição do apoio oferecido. Exemplo: "Fornecemos espaço para reuniões de grupos" (Obrigatório)';
COMMENT ON COLUMN TB_ENTIDADE_COMPLEMENTO.TP_ATENDIMENTO_PSICOSOCIAL IS 'Oferece atendimento psicossocial? (S=Sim, N=Não). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN TB_ENTIDADE_COMPLEMENTO.DS_ATENDIMENTO_PSICOSOCIAL IS 'Descrição do atendimento. Exemplo: "Atendimento individual semanal com psicólogo" (Obrigatório)';
COMMENT ON COLUMN TB_ENTIDADE_COMPLEMENTO.TP_ATIV_RESSOCIALI IS 'Desenvolve atividades de ressocialização? (S=Sim, N=Não). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN TB_ENTIDADE_COMPLEMENTO.TP_POSSUI_PARCERIAS IS 'Possui parcerias com outras instituições? (S=Sim, N=Não). Exemplo: "S" (Obrigatório)';

COMMENT ON TABLE TB_ENTIDADE_COMPLEMENTO IS 'Tabela que armazena informações complementares específicas sobre as entidades, especialmente relacionadas a metodologias de tratamento';



-- 
-- TABLE: TB_ESTRUTURA_FISICA 
--

CREATE TABLE TB_ESTRUTURA_FISICA(
    PK_CADASTRO_NACIONAL    NUMBER(38, 0)    NOT NULL,
    TP_ESPACO_ENTIDADE      CHAR(1)          NOT NULL,
    TP_ESPACO_FAMILIA       CHAR(1)          NOT NULL,
    TP_ESPACO_INDIVIDUAL    CHAR(1)          NOT NULL,
    CONSTRAINT PK21 PRIMARY KEY (PK_CADASTRO_NACIONAL)
)
;
COMMENT ON COLUMN TB_ESTRUTURA_FISICA.PK_CADASTRO_NACIONAL IS 'Chave primária que referencia o cadastro nacional. Exemplo: 42 (ID da entidade relacionada)';
COMMENT ON COLUMN TB_ESTRUTURA_FISICA.TP_ESPACO_ENTIDADE IS 'Possui espaço coletivo da entidade? (S=Sim, N=Não). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN TB_ESTRUTURA_FISICA.TP_ESPACO_FAMILIA IS 'Possui espaço para atendimento familiar? (S=Sim, N=Não). Exemplo: "N" (Obrigatório)';
COMMENT ON COLUMN TB_ESTRUTURA_FISICA.TP_ESPACO_INDIVIDUAL IS 'Possui espaço para atendimento individual? (S=Sim, N=Não). Exemplo: "S" (Obrigatório)';

COMMENT ON TABLE TB_ESTRUTURA_FISICA IS 'Tabela que registra a estrutura física disponível nas entidades para atendimento';


-- 
-- TABLE: TB_LOG 
--

CREATE TABLE TB_LOG(
    PK_LOG            NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    DT_DATA           DATE             NOT NULL,
    DS_DESCRICAO      VARCHAR2(200)    NOT NULL,
    NO_USUARIO        VARCHAR2(100)    NOT NULL,
    NO_MODULO         VARCHAR2(200)    NOT NULL,
    DS_VALOR          VARCHAR2(200)    NOT NULL,
    DS_COMPLEMENTO    VARCHAR2(200)    NOT NULL,
    CONSTRAINT PK23 PRIMARY KEY (PK_LOG)
)
;
COMMENT ON COLUMN TB_LOG.PK_LOG IS 'Chave primária autoincrementada do log. Exemplo: 1001, 1002... (Identificador único)';
COMMENT ON COLUMN TB_LOG.DT_DATA IS 'Data do registro do log (YYYY-MM-DD). Exemplo: 2025-03-28';
COMMENT ON COLUMN TB_LOG.DS_DESCRICAO IS 'Ação registrada. Exemplo: "Cadastro atualizado" (200 caracteres)';
COMMENT ON COLUMN TB_LOG.NO_USUARIO IS 'Usuário que realizou a ação. Exemplo: "admin" (100 caracteres)';
COMMENT ON COLUMN TB_LOG.NO_MODULO IS 'Módulo do sistema. Exemplo: "Cadastro Nacional" (200 caracteres)';
COMMENT ON COLUMN TB_LOG.DS_VALOR IS 'Valor alterado. Exemplo: "Status: P→A" (200 caracteres)';
COMMENT ON COLUMN TB_LOG.DS_COMPLEMENTO IS 'Detalhes adicionais. Exemplo: "Atualizado via importação" (200 caracteres)';
COMMENT ON TABLE TB_LOG IS 'Registra auditoria de todas as ações relevantes no sistema';


-- 
-- TABLE: TB_PERGUNTA 
--

CREATE TABLE TB_PERGUNTA(
    PK_PERGUNTAS          NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    NO_PERGUNTA           VARCHAR2(200)    NOT NULL,
    CO_DIRECAO            NUMBER(1, 0)     NOT NULL,
    TP_EXIBIR_PERGUNTA    CHAR(1)          NOT NULL,
    ST_PERGUNTA_ATIVO     CHAR(1)          NOT NULL,
    DT_ATUALIZACAO        TIMESTAMP(6)     NOT NULL,
    CONSTRAINT PK24 PRIMARY KEY (PK_PERGUNTAS)
)
;
COMMENT ON COLUMN TB_PERGUNTA.PK_PERGUNTAS IS 'Chave primária autoincrementada. Exemplo: 10, 11...';
COMMENT ON COLUMN TB_PERGUNTA.NO_PERGUNTA IS 'Texto completo. Exemplo: "Possui alvará?" (200 caracteres)';
COMMENT ON COLUMN TB_PERGUNTA.CO_DIRECAO IS 'Direção (0=Entrada, 1=Saída). Exemplo: 0';
COMMENT ON COLUMN TB_PERGUNTA.TP_EXIBIR_PERGUNTA IS 'Exibir? (S/N). Exemplo: "S"';
COMMENT ON COLUMN TB_PERGUNTA.ST_PERGUNTA_ATIVO IS 'Ativa? (S/N). Exemplo: "S"';
COMMENT ON COLUMN TB_PERGUNTA.DT_ATUALIZACAO IS 'Última atualização. Exemplo: 2025-03-28 10:00:00';
COMMENT ON TABLE TB_PERGUNTA IS 'Armazena todas as perguntas do questionário cadastral';



-- 
-- TABLE: TB_PROFISSAO 
--

CREATE TABLE TB_PROFISSAO(
    PK_PROFISSAO          NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    NO_PROFISSAO          VARCHAR2(200)    NOT NULL,
    ST_PROFISSAO_ATIVO    CHAR(1)          NOT NULL,
    DT_ATUALIZACAO        TIMESTAMP(6)     NOT NULL,
    CONSTRAINT PK20 PRIMARY KEY (PK_PROFISSAO)
)
;
COMMENT ON COLUMN TB_PROFISSAO.PK_PROFISSAO IS 'Chave primária autoincrementada. Exemplo: 5, 6...';
COMMENT ON COLUMN TB_PROFISSAO.NO_PROFISSAO IS 'Nome da profissão. Exemplo: "Assistente Social" (200 caracteres)';
COMMENT ON COLUMN TB_PROFISSAO.ST_PROFISSAO_ATIVO IS 'Ativa? (S/N). Exemplo: "S"';
COMMENT ON COLUMN TB_PROFISSAO.DT_ATUALIZACAO IS 'Última atualização. Exemplo: 2025-02-15 14:30:00';
COMMENT ON TABLE TB_PROFISSAO IS 'Cadastro de profissões da equipe técnica';


-- 
-- TABLE: TB_REPRESENTANTE_LEGAL 
--

CREATE TABLE TB_REPRESENTANTE_LEGAL(
    PK_REPRESENTANTE_LEGAL          NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    NO_NOME                         VARCHAR2(200)    NOT NULL,
    DT_TERMINO_MANDATO              DATE             NOT NULL,
    TP_PAPEL_DIRETORIA              CHAR(1),
    DT_NASCIMENTO                   DATE             NOT NULL,
    NU_CPF                          CHAR(11),
    NR_TELEFONE                     VARCHAR2(50),
    NO_EMAIL                        VARCHAR2(100)    NOT NULL,
    TP_ESCOLARIDADE                 CHAR(1)          NOT NULL,
    DS_PAPEL_DIRETORIA              VARCHAR2(200),
    NO_CURSO                        VARCHAR2(100),
    ST_REPRESENTANTE_LEGAL_ATIVO    CHAR(1)          NOT NULL,
    DT_ATUALIZACAO                  TIMESTAMP(6)     NOT NULL,
    PK_CADASTRO_NACIONAL            NUMBER(38, 0)    NOT NULL,
    CONSTRAINT PK6 PRIMARY KEY (PK_REPRESENTANTE_LEGAL)
);

-- Comentários das colunas com exemplos
COMMENT ON COLUMN TB_REPRESENTANTE_LEGAL.PK_REPRESENTANTE_LEGAL IS 'Chave primária autoincrementada do representante legal. Exemplo: 1, 2, 3... (Identificador único)';
COMMENT ON COLUMN TB_REPRESENTANTE_LEGAL.NO_NOME IS 'Nome completo do representante legal. Exemplo: "Maria da Silva Oliveira" (Máx. 200 caracteres)';
COMMENT ON COLUMN TB_REPRESENTANTE_LEGAL.DT_TERMINO_MANDATO IS 'Data de término do mandato no formato YYYY-MM-DD. Exemplo: 2026-12-31 (Data obrigatória)';
COMMENT ON COLUMN TB_REPRESENTANTE_LEGAL.TP_PAPEL_DIRETORIA IS 'Tipo de papel na diretoria (1=Presidente, 2=Vice, 3=Tesoureiro, etc.). Exemplo: 1 (Opcional)';
COMMENT ON COLUMN TB_REPRESENTANTE_LEGAL.DT_NASCIMENTO IS 'Data de nascimento no formato YYYY-MM-DD. Exemplo: 1980-05-15 (Data obrigatória)';
COMMENT ON COLUMN TB_REPRESENTANTE_LEGAL.NU_CPF IS 'CPF no formato 11 dígitos sem pontuação. Exemplo: 12345678901 (Opcional)';
COMMENT ON COLUMN TB_REPRESENTANTE_LEGAL.NR_TELEFONE IS 'Número de telefone com DDD. Exemplo: 61987654321 (Opcional, máx. 50 caracteres)';
COMMENT ON COLUMN TB_REPRESENTANTE_LEGAL.NO_EMAIL IS 'Endereço de e-mail válido. Exemplo: "maria.oliveira@entidade.org.br" (Obrigatório, máx. 100 caracteres)';
COMMENT ON COLUMN TB_REPRESENTANTE_LEGAL.TP_ESCOLARIDADE IS 'Grau de escolaridade (1=Fundamental, 2=Médio, 3=Superior, 4=Pós-graduação). Exemplo: 3 (Obrigatório)';
COMMENT ON COLUMN TB_REPRESENTANTE_LEGAL.DS_PAPEL_DIRETORIA IS 'Descrição detalhada do papel na diretoria. Exemplo: "Responsável pelas decisões estratégicas" (Opcional, máx. 200 caracteres)';
COMMENT ON COLUMN TB_REPRESENTANTE_LEGAL.NO_CURSO IS 'Nome do curso de formação principal. Exemplo: "Direito" (Opcional, máx. 100 caracteres)';
COMMENT ON COLUMN TB_REPRESENTANTE_LEGAL.ST_REPRESENTANTE_LEGAL_ATIVO IS 'Status do registro (S=Ativo, N=Inativo). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN TB_REPRESENTANTE_LEGAL.DT_ATUALIZACAO IS 'Data e hora da última atualização no formato TIMESTAMP. Exemplo: 2025-03-28 14:30:45.123456 (Obrigatório)';
COMMENT ON COLUMN TB_REPRESENTANTE_LEGAL.PK_CADASTRO_NACIONAL IS 'Chave estrangeira para TB_CADASTRO_NACIONAL. Exemplo: 42 (ID do cadastro vinculado, obrigatório)';

-- Comentário adicional sobre a tabela
COMMENT ON TABLE TB_REPRESENTANTE_LEGAL IS 'Tabela que armazena os dados dos representantes legais das entidades cadastradas, incluindo informações pessoais e de mandato';



-- 
-- TABLE: TB_REPRESENTANTE_TECNICO 
--

CREATE TABLE TB_REPRESENTANTE_TECNICO(
    PK_REPRESENTANTE_TECNICO          NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    NO_NOME                           VARCHAR2(200)    NOT NULL,
    DT_NASCIMENTO                     DATE             NOT NULL,
    NU_CPF                            CHAR(11)         NOT NULL,
    NR_TELEFONE                       VARCHAR2(100)    NOT NULL,
    NO_EMAIL                          VARCHAR2(200)    NOT NULL,
    TP_ESCOLARIDADE                   CHAR(1),
    NO_CURSO                          VARCHAR2(200)    NOT NULL,
    TP_POSSUI_EXPERIENCIA             CHAR(1),
    NU_RESPONSAVEL                    NUMBER(38, 0),
    ST_REPRESENTANTE_TECNICO_ATIVO    CHAR(1)          NOT NULL,
    DT_ATUALIZACAO                    TIMESTAMP(6)     NOT NULL,
    PK_CADASTRO_NACIONAL              NUMBER(38, 0)    NOT NULL,
    CONSTRAINT PK11 PRIMARY KEY (PK_REPRESENTANTE_TECNICO)
)
;
COMMENT ON COLUMN TB_REPRESENTANTE_TECNICO.PK_REPRESENTANTE_TECNICO IS 'Chave primária autoincrementada. Exemplo: 8, 9...';
COMMENT ON COLUMN TB_REPRESENTANTE_TECNICO.NO_NOME IS 'Nome completo. Exemplo: "Carlos Mendes" (200 caracteres)';
COMMENT ON COLUMN TB_REPRESENTANTE_TECNICO.DT_NASCIMENTO IS 'Data nascimento. Exemplo: 1985-07-22';
COMMENT ON COLUMN TB_REPRESENTANTE_TECNICO.NU_CPF IS 'CPF (11 dígitos). Exemplo: "98765432109"';
COMMENT ON COLUMN TB_REPRESENTANTE_TECNICO.NR_TELEFONE IS 'Telefone. Exemplo: "61999887766" (100 caracteres)';
COMMENT ON COLUMN TB_REPRESENTANTE_TECNICO.NO_EMAIL IS 'E-mail. Exemplo: "tecnico@entidade.org.br" (200 caracteres)';
COMMENT ON COLUMN TB_REPRESENTANTE_TECNICO.TP_ESCOLARIDADE IS 'Escolaridade (1-5). Exemplo: 4';
COMMENT ON COLUMN TB_REPRESENTANTE_TECNICO.NO_CURSO IS 'Formação. Exemplo: "Psicologia" (200 caracteres)';
COMMENT ON COLUMN TB_REPRESENTANTE_TECNICO.TP_POSSUI_EXPERIENCIA IS 'Experiência? (S/N). Exemplo: "S"';
COMMENT ON COLUMN TB_REPRESENTANTE_TECNICO.NU_RESPONSAVEL IS 'Nível responsabilidade (1-5). Exemplo: 3';
COMMENT ON TABLE TB_REPRESENTANTE_TECNICO IS 'Cadastro dos representantes técnicos das entidades';


-- 
-- TABLE: TB_RESPOSTA 
--

CREATE TABLE TB_RESPOSTA(
    PK_RESPOSTA          NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    NO_NOME              VARCHAR2(200)    NOT NULL,
    ST_RESPOSTA_ATIVO    CHAR(1)          NOT NULL,
    DT_ATUALIZACAO       TIMESTAMP(6)     NOT NULL,
    PK_PERGUNTAS         NUMBER(38, 0)    NOT NULL,
    CONSTRAINT PK12 PRIMARY KEY (PK_RESPOSTA)
)
;
COMMENT ON COLUMN TB_RESPOSTA.PK_RESPOSTA IS 'Chave primária autoincrementada. Exemplo: 45, 46...';
COMMENT ON COLUMN TB_RESPOSTA.NO_NOME IS 'Texto da resposta. Exemplo: "Sim, parcialmente" (200 caracteres)';
COMMENT ON COLUMN TB_RESPOSTA.ST_RESPOSTA_ATIVO IS 'Ativa? (S/N). Exemplo: "S"';
COMMENT ON COLUMN TB_RESPOSTA.DT_ATUALIZACAO IS 'Última atualização. Exemplo: 2025-03-10 10:15:00';
COMMENT ON COLUMN TB_RESPOSTA.PK_PERGUNTAS IS 'Pergunta relacionada. Exemplo: 10';
COMMENT ON TABLE TB_RESPOSTA IS 'Respostas pré-definidas para as perguntas do cadastro';



-- 
-- TABLE: TB_TIPO_ARQUIVOS 
--

CREATE TABLE TB_TIPO_ARQUIVOS(
    PK_TIPO_ARQUIVO          NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    NO_TIPO_ARQUIVO          VARCHAR2(200)    NOT NULL,
    ST_TIPO_ARQUIVO_ATIVO    CHAR(1)          NOT NULL,
    DT_ATUALIZACAO           TIMESTAMP(6)     NOT NULL,
    CONSTRAINT PK2 PRIMARY KEY (PK_TIPO_ARQUIVO)
)
;
COMMENT ON COLUMN TB_TIPO_ARQUIVOS.PK_TIPO_ARQUIVO IS 'Chave primária autoincrementada. Exemplo: 3, 4...';
COMMENT ON COLUMN TB_TIPO_ARQUIVOS.NO_TIPO_ARQUIVO IS 'Descrição do tipo. Exemplo: "Certidão Negativa" (200 caracteres)';
COMMENT ON COLUMN TB_TIPO_ARQUIVOS.ST_TIPO_ARQUIVO_ATIVO IS 'Ativo? (S/N). Exemplo: "S"';
COMMENT ON COLUMN TB_TIPO_ARQUIVOS.DT_ATUALIZACAO IS 'Última atualização. Exemplo: 2025-01-20 16:45:00';
COMMENT ON TABLE TB_TIPO_ARQUIVOS IS 'Tipos de documentos/arquivos aceitos no sistema';



-- 
-- TABLE: TB_TIPO_ATENDIMENTO 
--

CREATE TABLE TB_TIPO_ATENDIMENTO(
    PK_TIPO_ATENDIMENTO          NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    NO_NOME                      VARCHAR2(200)    NOT NULL,
    NU_GRUPO                     NUMBER(38, 0)    NOT NULL,
    ST_TIPO_ATENDIMENTO_ATIVO    CHAR(1)          NOT NULL,
    DT_ATUALIZACAO               TIMESTAMP(6)     NOT NULL,
    CONSTRAINT PK15 PRIMARY KEY (PK_TIPO_ATENDIMENTO)
)
;
COMMENT ON COLUMN TB_TIPO_ATENDIMENTO.PK_TIPO_ATENDIMENTO IS 'Chave primária autoincrementada do tipo de atendimento. Exemplo: 5, 6... (Identificador único)';
COMMENT ON COLUMN TB_TIPO_ATENDIMENTO.NO_NOME IS 'Nome completo do tipo de atendimento. Exemplo: "Acolhimento Institucional" (Obrigatório, máx. 200 caracteres)';
COMMENT ON COLUMN TB_TIPO_ATENDIMENTO.NU_GRUPO IS 'Código do grupo de classificação. Exemplo: 1 (para "Crianças e Adolescentes") (Obrigatório)';
COMMENT ON COLUMN TB_TIPO_ATENDIMENTO.ST_TIPO_ATENDIMENTO_ATIVO IS 'Status de ativação (S=Ativo, N=Inativo). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN TB_TIPO_ATENDIMENTO.DT_ATUALIZACAO IS 'Data e hora da última atualização. Exemplo: 2025-02-28 11:20:00.000000 (Obrigatório)';
COMMENT ON TABLE TB_TIPO_ATENDIMENTO IS 'Tabela de domínio que classifica os tipos de atendimentos/serviços oferecidos pelas entidades';



-- 
-- TABLE: TB_TIPO_CONTATO 
--

CREATE TABLE TB_TIPO_CONTATO(
    PK_TIPO_CONTATO    NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    NO_TIPO_CONTATO    VARCHAR2(100)    NOT NULL,
    ST_TIPO_CONTATO    CHAR(1)          NOT NULL,
    DT_ATUALIZACAO     TIMESTAMP(6)     NOT NULL,
    CONSTRAINT PK10 PRIMARY KEY (PK_TIPO_CONTATO)
)
;

COMMENT ON COLUMN TB_TIPO_CONTATO.PK_TIPO_CONTATO IS 'Chave primária autoincrementada do tipo de contato. Exemplo: 2, 3... (Identificador único)';
COMMENT ON COLUMN TB_TIPO_CONTATO.NO_TIPO_CONTATO IS 'Descrição do tipo de contato. Exemplo: "Telefone Celular" (Obrigatório, máx. 100 caracteres)';
COMMENT ON COLUMN TB_TIPO_CONTATO.ST_TIPO_CONTATO IS 'Status de ativação (S=Ativo, N=Inativo). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN TB_TIPO_CONTATO.DT_ATUALIZACAO IS 'Data e hora da última atualização. Exemplo: 2025-03-15 09:10:00.000000 (Obrigatório)';
COMMENT ON TABLE TB_TIPO_CONTATO IS 'Tabela de domínio que classifica os tipos de contatos aceitos no sistema (telefones, emails, etc.)';


-- 
-- TABLE: TB_TIPO_FINANCIAMENTO 
--

CREATE TABLE TB_TIPO_FINANCIAMENTO(
    PK_TIPO_FINANCIAMENTO          NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    NO_NOME                        VARCHAR2(200)    NOT NULL,
    NU_GRUPO                       NUMBER(38, 0)    NOT NULL,
    ST_TIPO_FINANCIAMENTO_ATIVO    CHAR(1)          NOT NULL,
    DT_ATUALIZACAO                 TIMESTAMP(6)     NOT NULL,
    CONSTRAINT PK17 PRIMARY KEY (PK_TIPO_FINANCIAMENTO)
)
;

COMMENT ON COLUMN TB_TIPO_FINANCIAMENTO.PK_TIPO_FINANCIAMENTO IS 'Chave primária autoincrementada do tipo de financiamento. Exemplo: 3, 4... (Identificador único)';
COMMENT ON COLUMN TB_TIPO_FINANCIAMENTO.NO_NOME IS 'Nome do tipo de financiamento. Exemplo: "Recursos Próprios" (Obrigatório, máx. 200 caracteres)';
COMMENT ON COLUMN TB_TIPO_FINANCIAMENTO.NU_GRUPO IS 'Código do grupo de classificação. Exemplo: 1 (para "Fontes Públicas") (Obrigatório)';
COMMENT ON COLUMN TB_TIPO_FINANCIAMENTO.ST_TIPO_FINANCIAMENTO_ATIVO IS 'Status de ativação (S=Ativo, N=Inativo). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN TB_TIPO_FINANCIAMENTO.DT_ATUALIZACAO IS 'Data e hora da última atualização. Exemplo: 2025-03-05 14:00:00.000000 (Obrigatório)';
COMMENT ON TABLE TB_TIPO_FINANCIAMENTO IS 'Tabela de domínio que classifica as fontes de financiamento das entidades';


-- 
-- TABLE: TB_VINCULO 
--

CREATE TABLE TB_VINCULO(
    PK_VINCULO          NUMBER(38, 0)    GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 NOCYCLE),
    NO_VINCULO          VARCHAR2(200)    NOT NULL,
    ST_VINCULO_ATIVO    CHAR(1)          NOT NULL,
    DT_ATUALIZACAO      TIMESTAMP(6)     NOT NULL,
    CONSTRAINT PK19 PRIMARY KEY (PK_VINCULO)
)
;

COMMENT ON COLUMN TB_VINCULO.PK_VINCULO IS 'Chave primária autoincrementada do tipo de vínculo. Exemplo: 2, 3... (Identificador único)';
COMMENT ON COLUMN TB_VINCULO.NO_VINCULO IS 'Descrição do tipo de vínculo. Exemplo: "CLT" (Obrigatório, máx. 200 caracteres)';
COMMENT ON COLUMN TB_VINCULO.ST_VINCULO_ATIVO IS 'Status de ativação (S=Ativo, N=Inativo). Exemplo: "S" (Obrigatório)';
COMMENT ON COLUMN TB_VINCULO.DT_ATUALIZACAO IS 'Data e hora da última atualização. Exemplo: 2025-01-10 10:30:00.000000 (Obrigatório)';
COMMENT ON TABLE TB_VINCULO IS 'Tabela de domínio que classifica os tipos de vínculos empregatícios da equipe técnica';


-- 
-- INDEX: Ref110 
--

CREATE INDEX Ref110 ON RL_ARQUIVOS(PK_CADASTRO_NACIONAL)
;
-- 
-- INDEX: Ref211 
--

CREATE INDEX Ref211 ON RL_ARQUIVOS(PK_TIPO_ARQUIVO)
;
-- 
-- INDEX: Ref112 
--

CREATE INDEX Ref112 ON RL_ATENDIMENTO(PK_CADASTRO_NACIONAL)
;
-- 
-- INDEX: Ref1513 
--

CREATE INDEX Ref1513 ON RL_ATENDIMENTO(PK_TIPO_ATENDIMENTO)
;
-- 
-- INDEX: Ref13 
--

CREATE INDEX Ref13 ON RL_CONTATOS(PK_CADASTRO_NACIONAL)
;
-- 
-- INDEX: Ref104 
--

CREATE INDEX Ref104 ON RL_CONTATOS(PK_TIPO_CONTATO)
;
-- 
-- INDEX: Ref116 
--

CREATE INDEX Ref116 ON RL_EQUIPE_TECNICA(PK_CADASTRO_NACIONAL)
;
-- 
-- INDEX: Ref2017 
--

CREATE INDEX Ref2017 ON RL_EQUIPE_TECNICA(PK_PROFISSAO)
;
-- 
-- INDEX: Ref1918 
--

CREATE INDEX Ref1918 ON RL_EQUIPE_TECNICA(PK_VINCULO)
;
-- 
-- INDEX: Ref1714 
--

CREATE INDEX Ref1714 ON RL_MAPA_VAGAS(PK_TIPO_FINANCIAMENTO)
;
-- 
-- INDEX: Ref115 
--

CREATE INDEX Ref115 ON RL_MAPA_VAGAS(PK_CADASTRO_NACIONAL)
;
-- 
-- INDEX: Ref1222 
--

CREATE INDEX Ref1222 ON RL_RESPOSTA_SELECIONADA(PK_RESPOSTA)
;
-- 
-- INDEX: Ref123 
--

CREATE INDEX Ref123 ON RL_RESPOSTA_SELECIONADA(PK_CADASTRO_NACIONAL)
;
-- 
-- INDEX: Ref126 
--

CREATE INDEX Ref126 ON TB_DILIGENCIA(PK_CADASTRO_NACIONAL)
;
-- 
-- INDEX: Ref12 
--

CREATE INDEX Ref12 ON TB_ENDERECO(PK_CADASTRO_NACIONAL)
;
-- 
-- INDEX: Ref124 
--

CREATE INDEX Ref124 ON TB_ENTIDADE_COMPLEMENTO(PK_CADASTRO_NACIONAL)
;
-- 
-- INDEX: Ref119 
--

CREATE INDEX Ref119 ON TB_ESTRUTURA_FISICA(PK_CADASTRO_NACIONAL)
;
-- 
-- INDEX: Ref15 
--

CREATE INDEX Ref15 ON TB_REPRESENTANTE_LEGAL(PK_CADASTRO_NACIONAL)
;
-- 
-- INDEX: Ref17 
--

CREATE INDEX Ref17 ON TB_REPRESENTANTE_TECNICO(PK_CADASTRO_NACIONAL)
;
-- 
-- INDEX: Ref2425 
--

CREATE INDEX Ref2425 ON TB_RESPOSTA(PK_PERGUNTAS)
;
-- 
-- TABLE: RL_ARQUIVOS 
--

ALTER TABLE RL_ARQUIVOS ADD CONSTRAINT RefTB_CADASTRO_NACIONAL101 
    FOREIGN KEY (PK_CADASTRO_NACIONAL)
    REFERENCES TB_CADASTRO_NACIONAL(PK_CADASTRO_NACIONAL)
;

ALTER TABLE RL_ARQUIVOS ADD CONSTRAINT RefTB_TIPO_ARQUIVOS111 
    FOREIGN KEY (PK_TIPO_ARQUIVO)
    REFERENCES TB_TIPO_ARQUIVOS(PK_TIPO_ARQUIVO)
;


-- 
-- TABLE: RL_ATENDIMENTO 
--

ALTER TABLE RL_ATENDIMENTO ADD CONSTRAINT RefTB_CADASTRO_NACIONAL121 
    FOREIGN KEY (PK_CADASTRO_NACIONAL)
    REFERENCES TB_CADASTRO_NACIONAL(PK_CADASTRO_NACIONAL)
;

ALTER TABLE RL_ATENDIMENTO ADD CONSTRAINT RefTB_TIPO_ATENDIMENTO131 
    FOREIGN KEY (PK_TIPO_ATENDIMENTO)
    REFERENCES TB_TIPO_ATENDIMENTO(PK_TIPO_ATENDIMENTO)
;


-- 
-- TABLE: RL_CONTATOS 
--

ALTER TABLE RL_CONTATOS ADD CONSTRAINT RefTB_CADASTRO_NACIONAL31 
    FOREIGN KEY (PK_CADASTRO_NACIONAL)
    REFERENCES TB_CADASTRO_NACIONAL(PK_CADASTRO_NACIONAL)
;

ALTER TABLE RL_CONTATOS ADD CONSTRAINT RefTB_TIPO_CONTATO41 
    FOREIGN KEY (PK_TIPO_CONTATO)
    REFERENCES TB_TIPO_CONTATO(PK_TIPO_CONTATO)
;


-- 
-- TABLE: RL_EQUIPE_TECNICA 
--

ALTER TABLE RL_EQUIPE_TECNICA ADD CONSTRAINT RefTB_CADASTRO_NACIONAL161 
    FOREIGN KEY (PK_CADASTRO_NACIONAL)
    REFERENCES TB_CADASTRO_NACIONAL(PK_CADASTRO_NACIONAL)
;

ALTER TABLE RL_EQUIPE_TECNICA ADD CONSTRAINT RefTB_PROFISSAO171 
    FOREIGN KEY (PK_PROFISSAO)
    REFERENCES TB_PROFISSAO(PK_PROFISSAO)
;

ALTER TABLE RL_EQUIPE_TECNICA ADD CONSTRAINT RefTB_VINCULO181 
    FOREIGN KEY (PK_VINCULO)
    REFERENCES TB_VINCULO(PK_VINCULO)
;


-- 
-- TABLE: RL_MAPA_VAGAS 
--

ALTER TABLE RL_MAPA_VAGAS ADD CONSTRAINT RefTB_TIPO_FINANCIAMENTO141 
    FOREIGN KEY (PK_TIPO_FINANCIAMENTO)
    REFERENCES TB_TIPO_FINANCIAMENTO(PK_TIPO_FINANCIAMENTO)
;

ALTER TABLE RL_MAPA_VAGAS ADD CONSTRAINT RefTB_CADASTRO_NACIONAL151 
    FOREIGN KEY (PK_CADASTRO_NACIONAL)
    REFERENCES TB_CADASTRO_NACIONAL(PK_CADASTRO_NACIONAL)
;


-- 
-- TABLE: RL_RESPOSTA_SELECIONADA 
--

ALTER TABLE RL_RESPOSTA_SELECIONADA ADD CONSTRAINT RefTB_RESPOSTA221 
    FOREIGN KEY (PK_RESPOSTA)
    REFERENCES TB_RESPOSTA(PK_RESPOSTA)
;

ALTER TABLE RL_RESPOSTA_SELECIONADA ADD CONSTRAINT RefTB_CADASTRO_NACIONAL231 
    FOREIGN KEY (PK_CADASTRO_NACIONAL)
    REFERENCES TB_CADASTRO_NACIONAL(PK_CADASTRO_NACIONAL)
;


-- 
-- TABLE: TB_DILIGENCIA 
--

ALTER TABLE TB_DILIGENCIA ADD CONSTRAINT RefTB_CADASTRO_NACIONAL261 
    FOREIGN KEY (PK_CADASTRO_NACIONAL)
    REFERENCES TB_CADASTRO_NACIONAL(PK_CADASTRO_NACIONAL)
;


-- 
-- TABLE: TB_ENDERECO 
--

ALTER TABLE TB_ENDERECO ADD CONSTRAINT RefTB_CADASTRO_NACIONAL21 
    FOREIGN KEY (PK_CADASTRO_NACIONAL)
    REFERENCES TB_CADASTRO_NACIONAL(PK_CADASTRO_NACIONAL)
;


-- 
-- TABLE: TB_ENTIDADE_COMPLEMENTO 
--

ALTER TABLE TB_ENTIDADE_COMPLEMENTO ADD CONSTRAINT RefTB_CADASTRO_NACIONAL241 
    FOREIGN KEY (PK_CADASTRO_NACIONAL)
    REFERENCES TB_CADASTRO_NACIONAL(PK_CADASTRO_NACIONAL)
;


-- 
-- TABLE: TB_ESTRUTURA_FISICA 
--

ALTER TABLE TB_ESTRUTURA_FISICA ADD CONSTRAINT RefTB_CADASTRO_NACIONAL191 
    FOREIGN KEY (PK_CADASTRO_NACIONAL)
    REFERENCES TB_CADASTRO_NACIONAL(PK_CADASTRO_NACIONAL)
;


-- 
-- TABLE: TB_REPRESENTANTE_LEGAL 
--

ALTER TABLE TB_REPRESENTANTE_LEGAL ADD CONSTRAINT RefTB_CADASTRO_NACIONAL51 
    FOREIGN KEY (PK_CADASTRO_NACIONAL)
    REFERENCES TB_CADASTRO_NACIONAL(PK_CADASTRO_NACIONAL)
;


-- 
-- TABLE: TB_REPRESENTANTE_TECNICO 
--

ALTER TABLE TB_REPRESENTANTE_TECNICO ADD CONSTRAINT RefTB_CADASTRO_NACIONAL71 
    FOREIGN KEY (PK_CADASTRO_NACIONAL)
    REFERENCES TB_CADASTRO_NACIONAL(PK_CADASTRO_NACIONAL)
;


-- 
-- TABLE: TB_RESPOSTA 
--

ALTER TABLE TB_RESPOSTA ADD CONSTRAINT RefTB_PERGUNTA251 
    FOREIGN KEY (PK_PERGUNTAS)
    REFERENCES TB_PERGUNTA(PK_PERGUNTAS)
;

