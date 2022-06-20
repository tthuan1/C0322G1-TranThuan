use manager_furama;
-- task 3
SELECT *
FROM
    khach_hang
WHERE
    (YEAR(CURDATE()) - YEAR(ngay_sinh) BETWEEN 18 AND 50)
        AND dia_chi LIKE '%Đà Nẵng%'
        OR dia_chi LIKE '%Quảng Trị%'; 