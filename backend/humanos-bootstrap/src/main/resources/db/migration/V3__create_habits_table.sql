CREATE TABLE habits (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    category VARCHAR(50) NOT NULL,
    measurement VARCHAR(50) NOT NULL,
    direction VARCHAR(20) NOT NULL
);