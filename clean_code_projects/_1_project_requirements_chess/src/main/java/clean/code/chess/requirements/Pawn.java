package clean.code.chess.requirements;

public class Pawn extends Piece {



    public Pawn(PieceColor pieceColor) {
        super(pieceColor);
        this.pieceColor = pieceColor;
    }

    public boolean IsValidMOveForPawn(int newY){
        if(this.getPieceColor() == PieceColor.BLACK){
            return (this.getYCoordinate() - 1 == newY);
        }else{
            return (this.getYCoordinate() + 1 == newY);
        }
    }


    public void Move(MovementType movementType, int newX, int newY) {
        if(movementType == MovementType.CAPTURE){
            throw new UnsupportedOperationException("Need to implement Pawn.Move() for capture");
        }else{
            if(this.getXCoordinate() == newX && IsValidMOveForPawn(newY)){
                this.getChesssBoard().Add(this, newX, newY, pieceColor);
            }
        }
    }

    @Override
    public String toString() {
        return CurrentPositionAsString();
    }

    protected String CurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
