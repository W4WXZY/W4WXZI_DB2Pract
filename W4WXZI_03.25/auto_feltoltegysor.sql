DECLARE
    v_rsz auto.rsz%TYPE := 'ABC123';
    v_tipus auto.tipus%TYPE := 'Toyota';
    v_szin auto.szin%TYPE := 'piros';
    v_kor auto.kor%TYPE := 5;
    v_ar auto.ar%TYPE := 3500000;
BEGIN
    INSERT INTO auto (rsz, tipus, szin, kor, ar)
    VALUES (v_rsz, v_tipus, v_szin, v_kor, v_ar);

    DBMS_OUTPUT.PUT_LINE('Rekord beszúrva!');
END;