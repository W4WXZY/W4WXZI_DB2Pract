DECLARE
    v_db NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_db
    FROM auto;

    DBMS_OUTPUT.PUT_LINE('Az autók darabszáma: ' || v_db);
END;