-- Create intended_use table
CREATE TABLE intended_use (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL
);

-- Insert data on intended_use table
INSERT INTO intended_use (name, code) VALUES
('hunting', 'INTD0001'),
('hiking', 'INTD0002'),
('camping', 'INTD0003'),
('fishing', 'INTD0004'),
('jungle_adventure', 'INTD0005'),
('slicing', 'INTD0006'),
('chopping', 'INTD0007'),
('dicing', 'INTD0008'),
('mincing', 'INTD0009'),
('julienning', 'INTD0010'),
('batonnet', 'INTD0011'),
('segmenting', 'INTD0012'),
('peeling', 'INTD0013'),
('trimming', 'INTD0014'),
('scoring', 'INTD0015'),
('carving', 'INTD0016'),
('filleting', 'INTD0017'),
('gutting', 'INTD0018'),
('self_defence', 'INTD0019'),
('combat', 'INTD0020'),
('throwing', 'INTD0021'),
('paper_cutting', 'INTD0022'),
('boning', 'INTD0023'),
('deboning', 'INTD0024'),
('gutting', 'INTD0025'),
('carving', 'INTD0026'),
('slicing_smoked_meat', 'INTD0027'),
('slicing_fish', 'INTD0028'),
('slicing_bacon', 'INTD0029'),
('slicing_salami', 'INTD0030');