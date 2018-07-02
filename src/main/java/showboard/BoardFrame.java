package showboard;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observer;

import javax.swing.JFrame;

public class BoardFrame extends JFrame implements IBoard {
	
	private static final long serialVersionUID = -1561359738513452134L;
	
	private static final int defaultFrameSize = 600;
	
	private final BoardPanel  boardPanel;
	
    public BoardFrame(final String title, final Boolean decorated) {
        super();
        this.setTitle(title);
        this.setSize(defaultFrameSize, defaultFrameSize);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(decorated);
        this.boardPanel = new BoardPanel();
        this.setContentPane(this.boardPanel);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    
    public BoardFrame(final String title) {
        this(title, false);
    }
    
    
    public BoardFrame() {
        this("", false);
    }
    
    
    public BoardFrame(final Boolean decorated) {
        this("", decorated);
    }
    
    
    @Override
    public final void addSquare(final ISquare square, final int x, final int y) {
        this.getBoardPanel().addSquare(square, x, y);
    }

    
    @Override    
    public final void addPawn(final IPawn pawn) {
        this.getBoardPanel().addPawn(pawn);
    }

    
    @Override    
    public final Observer getObserver() {
        return (Observer) this.getBoardPanel();
    }

    
    @Override    
    public final void setDimension(final Dimension dimension) {
        this.getBoardPanel().setDimension(dimension);
    }

    
    @Override
    public final Dimension getDimension() {
        return this.getBoardPanel().getDimension();
    }

    
    public final Rectangle getDisplayFrame() {
        return this.getBoardPanel().getDisplayFrame();
    }

    
    @Override
    public final void setDisplayFrame(final Rectangle displayFrame) {
        this.getBoardPanel().setDisplayFrame(displayFrame);
    }

    
    private BoardPanel getBoardPanel() {
        return this.boardPanel;
    }

    
    public final Boolean isWidthLooped() {
        return this.getBoardPanel().isWidthLooped();
    }

    
    public final void setWidthLooped(final Boolean widthLooped) {
        this.getBoardPanel().setWidthLooped(widthLooped);
    }

    
    public final Boolean isHeightLooped() {
        return this.getBoardPanel().isHeightLooped();
    }

    
    public final void setHeightLooped(final Boolean heightLooped) {
        this.getBoardPanel().setHeightLooped(heightLooped);
    }

}
