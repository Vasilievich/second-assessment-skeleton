insert into second_assignment.users (username, firstname, lastname, email, phone, timestamps, password, active) values ('yer1', 'yer', 'yang', 'yvyang13',
'651329', '10:36', 'lineage2', true);

insert into second_assignment.users (username, firstname, lastname, email, phone, timestamps, password, active) values ('danny', 'pa', 'xiong', 'paxiong01',
'651424', '09:41', 'idontknow', true);

insert into second_assignment.users (username, firstname, lastname, email, phone, timestamps, password, active) values ('djenny', 'jennifer', 'yang', 'jenyang09',
'763123', '09:41', 'idontknow2', true);

insert into second_assignment.hashtag (id, label, hashtagactive) values (1,'whatever', true);

insert into second_assignment.tweet (id, author, posted, context, tweetactive) values (1, 'yer', 'today', 'fuckyall', true);

insert into second_assignment.usertweets (users_id, tweet_id) values (1, 1);

insert into second_assignment.tweethashtags (tweet_id, hashtag_id) values (1, 1);