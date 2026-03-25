DECLARE
    v_kor NUMBER := 10;
BEGIN
    DELETE FROM auto
    WHERE kor > v_kor;

    DBMS_OUTPUT.PUT_LINE('A törlés megtörtént.');
END;