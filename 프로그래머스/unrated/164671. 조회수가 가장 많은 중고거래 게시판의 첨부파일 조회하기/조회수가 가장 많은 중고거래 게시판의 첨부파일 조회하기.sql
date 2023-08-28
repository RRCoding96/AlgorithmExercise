-- 코드를 입력하세요
SELECT CONCAT("/home/grep/src/", f.board_id, "/", f.file_id, f.file_name, f.file_ext) as FILE_PATH
FROM USED_GOODS_FILE f
JOIN USED_GOODS_BOARD b ON f.board_id = b.board_id
WHERE b.views = (
    SELECT MAX(views) 
    FROM USED_GOODS_BOARD
)
ORDER BY f.file_id DESC
;