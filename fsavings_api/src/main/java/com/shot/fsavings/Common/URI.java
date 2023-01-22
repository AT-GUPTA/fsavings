package com.shot.fsavings.Common;

public interface URI {
    String SAVE_USER_INFO="/save-user-info";
    String USER_CHECK = "/{email}/user-check";
    String UPDATE_USER_INFO="/update-user-info";

    String ADD_TRANSACTION = "/add-transaction";
    String ADD_ALL_TRANSACTION = "/get-transaction-from-csv";
    String USER_TRANSACTION = "/{id}/user-transaction-id";
}
