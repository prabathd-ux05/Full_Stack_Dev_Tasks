-- Main table
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Log table
CREATE TABLE student_logs (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    action_type VARCHAR(20),
    action_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Trigger for INSERT
DELIMITER $$

CREATE TRIGGER after_student_insert
AFTER INSERT ON students
FOR EACH ROW
BEGIN
    INSERT INTO student_logs (student_id, action_type)
    VALUES (NEW.id, 'INSERT');
END $$

DELIMITER ;

-- Trigger for UPDATE
DELIMITER $$

CREATE TRIGGER after_student_update
AFTER UPDATE ON students
FOR EACH ROW
BEGIN
    INSERT INTO student_logs (student_id, action_type)
    VALUES (NEW.id, 'UPDATE');
END $$

DELIMITER ;

-- View for daily report
CREATE VIEW daily_activity_report AS
SELECT
    DATE(action_time) AS activity_date,
    action_type,
    COUNT(*) AS total_actions
FROM student_logs
GROUP BY DATE(action_time), action_type;


INSERT INTO students (name, department)
VALUES ('Prabath', 'Computer Science');

UPDATE students
SET department = 'IT'
WHERE id = 1;
