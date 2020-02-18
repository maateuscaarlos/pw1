    CREATE TABLE CARTEIRA (
        id serial,
        valorCaixa FLOAT(10) NOT NULL,
        PRIMARY KEY (id)
    );

    CREATE TABLE ATIVO (
        id serial,
        nome VARCHAR(100) NOT NULL,
        precoDeCompra FLOAT(10) NOT NULL,
        quantidade FLOAT(10) NOT NULL,
        idCarteira serial NOT NULL,
        disponibilidade VARCHAR(30) NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (idCarteira) REFERENCES CARTEIRA(id)
    );

    CREATE TABLE USUARIO (
        id serial,
        nome VARCHAR(100) NOT NULL,
        email VARCHAR(100) NOT NULL,
        senha VARCHAR (50) NOT NULL,
        nascimento DATE NOT NULL,
        idCarteira serial NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (idCarteira) REFERENCES CARTEIRA(id)
    );

    CREATE TABLE TRANSACAO (
        id serial,
        idAtivo serial NOT NULL,
        idUser serial NOT NULL,
        dia DATE NOT NULL,
        valor FLOAT(10) NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (idUser) REFERENCES USUARIO(id),
        FOREIGN KEY (idAtivo) REFERENCES ATIVO(id)
    );