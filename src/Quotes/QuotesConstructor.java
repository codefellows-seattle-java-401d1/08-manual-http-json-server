package Quotes;

public class QuotesConstructor <E>{
    //{
    // "tags": ["attributed-no-source"],
    // "author": "Marilyn Monroe",
    // "likes": "18651 likes",
    // "text": "\n      \u201cI am good, but not an angel. I do sin, but I am not the devil. I am just a small girl in a big world trying to find someone to love.\u201d\n  "
    // }
    public String[] tags;
    public String author;
    public String likes;
    public String text;


    public String toString() {
        return text + " -- " + this.author;
    }
}
