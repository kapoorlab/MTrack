package singleListeners;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import ij.IJ;
import interactiveMT.Interactive_MTDoubleChannelBasic;
import interactiveMT.Interactive_MTSingleChannel;
import interactiveMT.Interactive_MTSingleChannelBasic;
import updateListeners.BatchModeListener;
import updateListeners.DefaultModelHF;
import updateListeners.FinalPoint;
import updateListeners.Markends;
import updateListeners.MoveNextListener;
import updateListeners.MoveToFrameListener;
import updateListeners.SingleDefaultModelHF;
import updateListeners.SingleFinalPoint;

public class SingleSecondPanel {
	
	final  Interactive_MTSingleChannel parent;
	final Interactive_MTSingleChannelBasic child;
	
	
	public SingleSecondPanel(final  Interactive_MTSingleChannel parent, final Interactive_MTSingleChannelBasic child){
		
		this.parent = parent;
		this.child = child;
		
	}
	
	private JPanel Deselect = new JPanel();
	private JPanel Timeselect = new JPanel();
	private JPanel Batchselect = new JPanel();
	public void Paint(){
		
		
		// Panel Second
		
		Deselect.setLayout(child.layout);
		Timeselect.setLayout(child.layout);
		Batchselect.setLayout(child.layout);
		
		final JScrollBar timeslider = new JScrollBar(Scrollbar.HORIZONTAL, parent.thirdDimensionsliderInit, 10, 0, 10 + parent.scrollbarSize);
		
		final JScrollBar starttimeslider = new JScrollBar(Scrollbar.HORIZONTAL, parent.starttime, 10, 0, 10 + parent.scrollbarSize);
		
		final JScrollBar endtimeslider = new JScrollBar(Scrollbar.HORIZONTAL, parent.endtime, 10, 0, 10 + parent.scrollbarSize);
		
		parent.thirdDimension = parent.computeScrollbarPositionFromValue(parent.thirdDimensionsliderInit, parent.thirdDimensionsliderInit, parent.thirdDimensionSize, parent.scrollbarSize);
		
		
		
		
	

		final Button Exit = new Button("Close and exit");
		final Button Record = new Button("Save program parameters for batch mode");
		
		
		final String timestring = "Time point for choosing ends ";
		final String starttimestring = "Start time for tracking ";
		final String endtimestring = "End time for tracking ";
		final Label timeText = new Label("Current time point = " + parent.thirdDimension , Label.CENTER);
		final Label timeTextstart = new Label("Start time for tracking = " + parent.starttime, Label.CENTER);
		final Label timeTextend = new Label("End time for tracking = " + parent.endtime, Label.CENTER);
		
		
		
		
		
		Border selectborder = new CompoundBorder(new TitledBorder("Option 1"),
				new EmptyBorder(child.c.insets));
		
		Border timeborder = new CompoundBorder(new TitledBorder("Option 2"),
				new EmptyBorder(child.c.insets));
		
		Border batchborder = new CompoundBorder(new TitledBorder("Option 3"),
				new EmptyBorder(child.c.insets));
		
		
		
		final Label LeftClick = new Label(
				"Left click deselects an end");
		final Label SLeftClick = new Label( "Shift +  left click reselects a deselected end");
		final Label SALeftClick = new Label( "Shift + Alt + left click marks a user defined seed.");
		
		final Label Batchsave = new Label(
				"Save parameters for batch mode");
		
		
		Deselect.add(LeftClick,new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
		
		Deselect.add(SLeftClick,new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
		
		Deselect.add(SALeftClick,new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
		
		
		Deselect.add(timeText,new GridBagConstraints(0, 3, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
		Deselect.add(timeslider,new GridBagConstraints(0, 4, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
		
		Deselect.setBorder(selectborder);
		
		child.panelSecond.add(Deselect, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
		

		final JButton Finalize = new JButton("Confirm the end(s) and track");
		
		Timeselect.add(timeTextstart,new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
		
		Timeselect.add(starttimeslider,new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
		
		Timeselect.add(timeTextend,new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
		
		Timeselect.add(endtimeslider,new GridBagConstraints(0, 3, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
		
		Timeselect.add(Finalize,new GridBagConstraints(0, 4, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
		Timeselect.setBorder(timeborder);

		child.panelSecond.add(Timeselect, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
		
		
		
		Batchselect.add(Batchsave, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0) );
		
		Batchselect.add(Record, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0) );
		
		Batchselect.setBorder(batchborder);
		
		child.panelSecond.add(Batchselect, new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));

				
				child.inputLabelX = new JLabel("Enter start time point for tracking");
				child.inputFieldX = new TextField();
				child.inputFieldX.setColumns(5);

				child.inputLabelY = new JLabel("Enter end time point for tracking");
				child.inputFieldY = new TextField();
				child.inputFieldY.setColumns(5);
				child.inputFieldX.setText(String.valueOf(2));
				child.inputFieldY.setText(String.valueOf(parent.thirdDimensionSize));
				

			
				
			
				
				
				// Load default optimizer options 
				SingleDefaultModelHF loaddefaultHF = new SingleDefaultModelHF(parent);
				loaddefaultHF.LoadDefault();

			

				

				// ++c.gridy;
				// c.insets = new Insets(10, 10, 0, 50);
				// panelThird.add(Exit, c);

				Exit.addActionListener(new FinishedButtonListener(child.CardframeSimple, true));

				Record.addActionListener(new SingleBatchModeListener(parent));

				timeslider.addAdjustmentListener(new SingleTimeListener(parent, timeText,timestring, parent.thirdDimensionsliderInit , parent.thirdDimensionSize, parent.scrollbarSize,timeslider));
				starttimeslider.addAdjustmentListener(new SingleStarttimeListener(parent, timeTextstart, starttimestring, parent.thirdDimensionsliderInit, parent.thirdDimensionSize, parent.scrollbarSize,starttimeslider));
				endtimeslider.addAdjustmentListener(new SingleEndtimeListener(parent, timeTextend, endtimestring, parent.thirdDimensionsliderInit, parent.thirdDimensionSize, parent.scrollbarSize,endtimeslider));
			

				child.CardframeSimple.addWindowListener(new FrameListener(child.CardframeSimple));

				child.inputFieldX.addTextListener(new SingleBeginTrackListener(parent));
				child.inputFieldY.addTextListener(new SingleEndTrackListener(parent));
				Finalize.addActionListener(new SingleFinalPoint(parent, child));
				
				child.CardframeSimple.pack();
	
		
	}
	
	

	
	protected class FinishedButtonListener implements ActionListener {
		final Frame parentB;
		final boolean cancel;

		public FinishedButtonListener(Frame parentB, final boolean cancel) {
			this.parentB = parentB;
			this.cancel = cancel;
		}

		@Override
		public void actionPerformed(final ActionEvent arg0) {
			parent.wasCanceled = cancel;
			parent.close(parentB, parent.sliceObserver, parent.roiListener);
		}
	}

	protected class FrameListener extends WindowAdapter {
		final Frame parentB;

		public FrameListener(Frame parentB) {
			super();
			this.parentB = parentB;
		}

		@Override
		public void windowClosing(WindowEvent e) {
			parent.close(parentB, parent.sliceObserver, parent.preprocessedimp, parent.roiListener);
		}
	}

}