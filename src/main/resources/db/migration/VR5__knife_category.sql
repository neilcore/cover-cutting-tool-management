-- Create tables related to knives
CREATE TABLE knife_category (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    description TEXT,
    stock int DEFAULT 0
);

-- Insert data on knife_category table
INSERT INTO knife_category (name, description) VALUES
('kitchen', 'These are design for food preparation'),
('outdoor_and_utility', 'Build for durability and various tasks in non kitchen settings'),
('table', 'Used at the dining table for cutting'),
('speciality', 'Design for very specific purpose');

-- Create knife_model table
CREATE TABLE knife_model (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    description TEXT,
    model_number int NOT NULL,
    discontinued BOOLEAN DEFAULT FALSE,
    stock int DEFAULT 0,
    category uuid REFERENCES knife_category(id)
);

-- Insert data on knife_model table
INSERT INTO knife_model (name, description, model_number, discontinued, stock, category) VALUES
('chef knife', 'A versatile kitchen knife for chopping and slicing.', 101, FALSE, 0, (SELECT id FROM knife_category WHERE name = 'kitchen')),
('paring knife', 'A small knife for intricate tasks like peeling.', 102, FALSE, 0, (SELECT id FROM knife_category WHERE name = 'kitchen')),
('utility knife', 'useful for variety of tasks', 103, FALSE, 0, (SELECT id FROM knife_category WHERE name = 'outdoor_and_utility')),
('Hunting Knife', 'A sturdy knife for outdoor activities.', 104, FALSE, 0, (SELECT id FROM knife_category WHERE name = 'outdoor_and_utility')),
('Steak Knife', 'A serrated knife for cutting steak.', 105, FALSE, 0, (SELECT id FROM knife_category WHERE name = 'table')),
('Bread Knife', 'A long serrated blade for slicing bread.', 106, FALSE, 0, (SELECT id FROM knife_category WHERE name = 'table')),
('Sushi Knife', 'A specialized knife for sushi preparation.', 107, FALSE, 0, (SELECT id FROM knife_category WHERE name = 'kitchen')),
('Boning Knife', 'A flexible blade for deboning meat.', 108, FALSE,0, (SELECT id FROM knife_category WHERE name = 'kitchen'));