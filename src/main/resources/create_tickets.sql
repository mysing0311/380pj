CREATE TABLE ticket (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    name VARCHAR(255) NOT NULL,
    subject VARCHAR(255) NOT NULL,
    body VARCHAR(255) NOT NULL,
    price double check(price>0),
    bidNum int default 0,
    status VARCHAR(255) default 'avaliable',
    winner VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE attachment (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    filename VARCHAR(255) DEFAULT NULL,
    content_type VARCHAR(255) DEFAULT NULL,
    content BLOB DEFAULT NULL,
    ticket_id INTEGER DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (ticket_id) REFERENCES ticket(id) 
);

CREATE TABLE Comment (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    ticketID INTEGER DEFAULT NULL,
    comment VARCHAR(255),
    );
