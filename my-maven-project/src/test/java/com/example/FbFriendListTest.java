package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FbFriendListTest {
    private FbFriendList friendList;

    @BeforeEach
    void setUp() {
        friendList = new FbFriendList();
    }

    // Positive Test: Valid profile link with friends
    @Test
    void testGetFriendsWithValidProfileLink() {
        String[] friends = friendList.getFriends("valid_profile_link");
        assertNotNull(friends);
        assertEquals(3, friends.length);
        assertArrayEquals(new String[]{"Friend1", "Friend2", "Friend3"}, friends);
    }

    // Positive Test: Valid profile link with no friends
    @Test
    void testGetFriendsWithValidProfileLinkNoFriends() {
        String[] friends = friendList.getFriends("valid_profile_link_no_friends");
        assertNotNull(friends);
        assertEquals(0, friends.length);
    }

    // Positive Test: Valid profile link with one friend
    @Test
    void testGetFriendsWithValidProfileLinkOneFriend() {
        String[] friends = friendList.getFriends("valid_profile_link_one_friend");
        assertNotNull(friends);
        assertEquals(1, friends.length);
        assertEquals("Friend1", friends[0]);
    }

    // Negative Test: Invalid profile link with special characters
    @Test
    void testGetFriendsWithInvalidProfileLinkSpecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            friendList.getFriends("invalid_profile_link#123");
        });
    }

    // Negative Test: Invalid profile link with empty string
    @Test
    void testGetFriendsWithEmptyProfileLink() {
        assertThrows(IllegalArgumentException.class, () -> {
            friendList.getFriends("");
        });
    }

    // Negative Test: Invalid profile link with whitespace
    @Test
    void testGetFriendsWithWhitespaceProfileLink() {
        assertThrows(IllegalArgumentException.class, () -> {
            friendList.getFriends("   ");
        });
    }

    // Add more positive and negative tests as needed
}