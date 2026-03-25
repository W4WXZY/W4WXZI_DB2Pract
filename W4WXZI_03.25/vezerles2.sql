DECLARE
    a NUMBER := 10;
    b NUMBER := 81;
BEGIN
    IF a > b THEN
        DBMS_OUTPUT.PUT_LINE('A nagyobb szam: ' || a);
    ELSIF b > a THEN
        DBMS_OUTPUT.PUT_LINE('A nagyobb szam: ' || b);
    ELSE
        DBMS_OUTPUT.PUT_LINE('A két szám egyenlő.');
    END IF;
END