CREATE TABLE IF NOT EXISTS defect_severity (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL
);

INSERT INTO defect_severity (name, code) VALUES
('minor', 'DEF0001'),
('moderate', 'DEF0002'),
('major', 'DEF0003');

-- Create defective tools table
CREATE TABLE IF NOT EXISTS defective_tools (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    product_id uuid NOT NULL,
    tool_type uuid references cutting_tool_category(id) NOT NULL,
    product_sku varchar(255) NOT NULL,
    defect_detection_date DATE NOT NULL,
    defect_location DATE NOT NULL,
    defect_description varchar(255),
    defect_type varchar(100),
    defect_severity int references defect_severity(id),
    analysis_date DATE,
    resolution_status int,
    corrective_action varchar(255)
);