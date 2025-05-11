CREATE TABLE cutting_tool_category (
    id uuid DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    availability BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (id)
);