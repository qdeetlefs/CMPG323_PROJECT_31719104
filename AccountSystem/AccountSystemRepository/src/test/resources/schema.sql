CREATE SCHEMA cmpg323_accountsystem;

CREATE TABLE cmpg323_accountsystem.account_type
(
    account_type_id   int AUTO_INCREMENT NOT NULL,
    mnemonic          varchar(100)       NOT NULL UNIQUE,
    account_type_name varchar(255)       NOT NULL,
    creation_date     date               NOT NULL,
    PRIMARY KEY (account_type_id)
);


CREATE TABLE cmpg323_accountsystem.account_tx
(
    tx_id           int AUTO_INCREMENT NOT NULL,
    account_type_id int                NOT NULL,
    member_id       int                NOT NULL,
    amount          int                NOT NULL,
    tx_date         date               NOT NULL,
    PRIMARY KEY (tx_id),
    CONSTRAINT ACCOUNT_TYPE_ID_FK FOREIGN KEY (account_type_id) REFERENCES account_type (account_type_id)
);

CREATE TABLE cmpg323_accountsystem.account_tx_details
(
    account_tx_details_id int AUTO_INCREMENT NOT NULL,
    tx_id                 int                NOT NULL,
    partner_name          varchar(255)       NOT NULL,
    number_of_items       int                NOT NULL,
    PRIMARY KEY (account_tx_details_id),
    CONSTRAINT ACCOUNT_TYPE_ID_FK FOREIGN KEY (tx_id) REFERENCES account_tx (tx_id)
);
