CREATE OR REPLACE PROCEDURE auto_torlese_10_nagyobb IS
BEGIN
    DELETE FROM auto
    WHERE kor > 10;

    DBMS_OUTPUT.PUT_LINE('A 10 évnél idősebb autók törlése megtörtént.');
END;