# Write your MySQL query statement below
select p.project_id as project_id, round((sum(e.experience_years) / count(p.project_id)), 2) as average_years
from Employee e
inner join Project p on e.employee_id = p.employee_id
group by p.project_id
;