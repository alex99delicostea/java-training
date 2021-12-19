package clean.code.chess.requirements;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;
    private Boolean[][] Isoccupied;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
        Isoccupied = new Boolean[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
        for(int i = 0; i < MAX_BOARD_WIDTH; i++){
            for(int j = 0; j < MAX_BOARD_HEIGHT; j++){
                Isoccupied[i][j] = Boolean.FALSE;
            }
        }

    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if(IsLegalBoardPosition(xCoordinate, yCoordinate)){
            this.pieces[xCoordinate][yCoordinate] = pawn;
            this.Isoccupied[xCoordinate][yCoordinate] = Boolean.TRUE;
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pawn.setChessBoard(this);
            pawn.setPieceColor(pieceColor);
        }else{
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            System.out.println("Position is either invalid or already occupied");
        }
    }

    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return IsOnBoardPosition(xCoordinate, yCoordinate) && !this.Isoccupied[xCoordinate][yCoordinate];
    }
    public boolean IsOnBoardPosition(int xCoordinate, int yCoordinate){
        return (xCoordinate >= 0) && (xCoordinate < MAX_BOARD_WIDTH) && (yCoordinate >= 0) && (yCoordinate < MAX_BOARD_HEIGHT);
    }

}
