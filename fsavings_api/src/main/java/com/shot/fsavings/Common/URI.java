package com.shot.fsavings.Common;

public interface URI {
    String SAVE_USER_INFO="/save-user-info";
    String USER_CHECK = "/{email}/user-check";
    String REPORTS="/{userId}/reports";
    String UPDATE_USER_INFO="/{userId}/update-user-info";
    String ADD_TRANSACTION = "/add-transaction";
    String ADD_ALL_TRANSACTION = "/get-transaction-from-csv";
    String USER_TRANSACTION = "/{userId}/user-transaction-id";
    String GET_USER = "/{userId}/user";
    String SAVE_GOAL_INFO="/save-goal-info";
    String UPDATE_GOAL_INFO="/{userId}/update-goal-info";
}
