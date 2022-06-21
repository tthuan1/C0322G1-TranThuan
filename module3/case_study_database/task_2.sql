use manager_furama;

-- task 2
SELECT *
FROM
    nhan_vien
WHERE
    ho_ten LIKE 'H%' OR ho_ten LIKE 'T%'
        OR ho_ten LIKE 'K%'
        AND CHARACTER_LENGTH(ho_ten) < 15;
        
select substring_index(ho_ten, " ", -10) as `name` from nhan_vien
having
`name` LIKE 'H%' OR `name` LIKE 'T%'
        OR `name` LIKE 'K%'
	
;