create table user (
      id bigint auto_increment primary key,
      name varchar(20),
      email varchar(50),
      userId varchar(50),
      password varchar(100)
);

INSERT INTO user (name, email, userId, password) VALUES ('Alice', 'alice@example.com', 'alice123', 'password1');
INSERT INTO user (name, email, userId, password) VALUES ('Bob', 'bob@example.com', 'bob456', 'password2');
INSERT INTO user (name, email, userId, password) VALUES ('Charlie', 'charlie@example.com', 'charlie789', 'password3');
INSERT INTO user (name, email, userId, password) VALUES ('David', 'david@example.com', 'david321', 'password4');
INSERT INTO user (name, email, userId, password) VALUES ('Eve', 'eve@example.com', 'eve654', 'password5');