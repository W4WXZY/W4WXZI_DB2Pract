DECLARE
    v_atlag NUMBER;
BEGIN
    SELECT AVG(ar)
    INTO v_atlag
    FROM auto;

    DBMS_OUTPUT.PUT_LINE('Az autók átlagára: ' || v_atlag);
END;