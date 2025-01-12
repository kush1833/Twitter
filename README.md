# Twitter
A practice project to simulate Twitter backend with limited features

Design a low-level system architecture for a simplified version of Twitter. Your design should focus on the following core functionalities:

    User Management:
        #2 Users should be able to sign up, log in, and log out.
        #1 Store user profiles, which include basic information such as username, password, email.

    Tweet Management:
        Users should be able to post tweets (text content up to 280 characters).
        Each tweet should have a timestamp and be associated with the user who posted it.

    Timeline:
        Users should be able to see a timeline of tweets from the users they follow, sorted by the most recent tweets first.
        Users should be able to follow and unfollow other users.

    Like and Retweet:
        #1 Users should be able to like tweets.
        #2 Users should be able to retweet other users' tweets, which will also appear on their followers' timelines.

Constraints:

    Focus on the core functionalities mentioned above; additional features like comments, hashtags, direct messages, etc., are out of scope for this interview.
    

Deliverables:
    
    A Working application


Areas of Improvement:
    
    Input can be an interface so that multiple input sources can be used.
    Error handling can be improved. Add Custom exceptions with proper error messages.
    Add JavaDocs for better understanding of the code.
    Retweet functiionality is not implemented.