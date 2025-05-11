-- Create knife table
CREATE TABLE IF NOT EXISTS knife (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    model uuid references knife_model(id) NOT NULL,
    sku varchar(255) NOT NULL,
    manufacturer uuid references manufacturer(id) NOT NULL,
    physical_dimensions JSONB,
    blade_properties JSONB,
    handle_properties JSONB,
    features JSONB,
    intended_use uuid references intended_use(id) NOT NULL,
    country_origin varchar(100),
    date_added DATE NOT NULL DEFAULT CURRENT_DATE,
    price NUMERIC(10, 2)
);
-- M2M
CREATE TABLE knife_uses (
    uses_id uuid references intended_use(id),
    knife_id uuid references knife(id)
);