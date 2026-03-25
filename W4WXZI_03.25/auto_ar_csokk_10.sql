DECLARE
    v_kor NUMBER := 7;
BEGIN
    UPDATE auto
    SET ar = ar * 0.9
    WHERE kor > v_kor;

    DBMS_OUTPUT.PUT_LINE('Az árak csökkentése megtörtént.');
END;