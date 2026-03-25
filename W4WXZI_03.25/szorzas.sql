DECLARE
    a NUMBER := 10;
    b NUMBER := 5;
    szorzat NUMBER;
BEGIN
    szorzat := a * b;
    DBMS_OUTPUT.PUT_LINE('A szorzat: ' || szorzat);
END;