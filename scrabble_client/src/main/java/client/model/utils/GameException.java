package client.model.utils;

/**
 *
 * @author Bernard <bernard.debecker@gmail.com>, Romain <ro.foncier@gmail.com>
 */
public class GameException extends Exception {

    public enum typeErr {

        CONN_KO, PLAYER_EXISTS, PLAYER_NOT_EXISTS, PWDKO, SYSKO,
        NEW_ACCOUNT_ERROR, LOGIN_ERROR, NEW_GAME_ERROR, PLAYER_NOT_LOGGED, LOAD_GAME_LIST_ERROR,
        NEW_GAME_ANONYM_ERROR, DELETE_ANONYM_ERROR, TILE_EXCHANGE_ERROR, PLACE_WORD_ERROR,
        GAME_IDENT_ERROR, LOAD_GAME_ERROR, LOGOUT_ERROR, SAVE_GAME_ERROR,};
    private typeErr err;

    public GameException(typeErr err) {
        this.err = err;
    }

    public typeErr getError() {
        return err;
    }
}