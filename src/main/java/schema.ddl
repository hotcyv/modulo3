
    create table hibernate_sequence (
        next_val bigint
    ) ENGINE=InnoDB;

    insert into hibernate_sequence values ( 1 );

    create table Usuario (
        id bigint not null,
        email varchar(255),
        newsletter bit not null,
        senha varchar(255),
        primary key (id)
    ) ENGINE=InnoDB;

    create table hibernate_sequence (
        next_val bigint
    ) ENGINE=InnoDB;

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    create table Produto (
        id bigint not null,
        imagem varchar(255),
        nome varchar(255),
        preco decimal(19,2),
        primary key (id)
    ) ENGINE=InnoDB;

    create table Usuario (
        id bigint not null,
        email varchar(255),
        newsletter bit not null,
        senha varchar(255),
        primary key (id)
    ) ENGINE=InnoDB;

    create table hibernate_sequence (
        next_val bigint
    ) ENGINE=InnoDB;

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    create table Produto (
        id bigint not null,
        imagem varchar(255),
        nome varchar(255),
        preco decimal(19,2),
        primary key (id)
    ) ENGINE=InnoDB;

    create table Usuario (
        id bigint not null,
        email varchar(255),
        newsletter bit not null,
        senha varchar(255),
        primary key (id)
    ) ENGINE=InnoDB;
