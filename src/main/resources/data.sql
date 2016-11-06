insert into second_assignment.users (username, firstname, lastname, email, phone, password, active) values ('yer1', 'yer', 'yang', 'yvyang13',
'651329','lineage2', true);

insert into second_assignment.users (username, firstname, lastname, email, phone, password, active) values ('danny', 'pa', 'xiong', 'paxiong01',
'651424','idontknow', true);

insert into second_assignment.users (username, firstname, lastname, email, phone, password, active) values ('djenny', 'jennifer', 'yang', 'jenyang09',
'763123','idontknow2', true);

insert into second_assignment.hashtag (id, label, hashtagactive) values (1,'whatever', true);

insert into second_assignment.tweet (author, posted, context, active) values ('yer', 'today', 'fuckyall', true);

insert into second_assignment.tweet (author, posted, context, active) values ('yer', 'tomorrow', 'fuckyall2', true);

insert into second_assignment.tweet (author, posted, context, active) values ('yer', 'tomorrow', 'fuckyall3', true);

insert into second_assignment.tweet (author, posted, context, active) values ('pa', 'today', 'xaochan', true);

insert into second_assignment.usertweets (users_id, tweet_id) values (1, 1);

insert into second_assignment.usertweets (users_id, tweet_id) values (1, 2);

insert into second_assignment.usertweets (users_id, tweet_id) values (1, 3);

insert into second_assignment.usertweets (users_id, tweet_id) values (2, 4);

insert into second_assignment.tweethashtags (tweet_id, hashtag_id) values (1, 1);

insert into second_assignment.tweetlike (tweet_id, likedby_id) values (2, 1);
