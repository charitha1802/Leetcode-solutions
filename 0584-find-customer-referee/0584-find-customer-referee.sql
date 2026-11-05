# Write your MySQL query statement below
select name from customer
where customer.referee_id!=2 or customer.referee_id is null;
