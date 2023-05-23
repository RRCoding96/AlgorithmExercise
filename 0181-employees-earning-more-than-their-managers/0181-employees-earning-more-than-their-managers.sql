# Write your MySQL query statement below
SELECT e1.name AS Employee
FROM Employee AS e1
    inner JOIN Employee AS e2 ON e1.managerID = e2.ID
WHERE e1.salary > e2.Salary