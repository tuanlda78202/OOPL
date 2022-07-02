package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;
	
	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCartButton = new JButton("Add to cart");
		addToCartButton.addActionListener(new AddToCartListener());
		container.add(addToCartButton);
		
		JButton detailsButton = new JButton("View details");
		detailsButton.addActionListener(new DetailsListener());
		container.add(detailsButton);
		
		if (media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(new PlayButtonListener());
			container.add(playButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private class PlayButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				((Disc)media).play();
			} catch (PlayerException ex) {
				JPanel p = new JPanel();
				JDialog d = new JDialog();
				JLabel j1 = new JLabel(media.getTitle() + " cannot be played");
				JLabel j2 = new JLabel("Media length is non-positive");
				p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
				j1.setAlignmentX(Component.CENTER_ALIGNMENT);
				j2.setAlignmentX(Component.CENTER_ALIGNMENT);
				p.add(Box.createVerticalGlue());
				p.add(j1);
				p.add(j2);
				p.add(Box.createVerticalGlue());
				d.add(p);
				d.setSize(250,100);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				int w = d.getSize().width;
		        int h = d.getSize().height;
		        int x = (dim.width - w) / 2;
		        int y = (dim.height - h) / 2;
		        d.setLocation(x,y);
				d.setVisible(true);
			}
		}
	}
	
	private class AddToCartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel p = new JPanel();
			JDialog d = new JDialog();
			JLabel l = new JLabel();
			try {
				cart.addMedia(media);
				l.setText(media.getTitle() + " added to cart");
			} catch (CartFullException ex) {
				l.setText("The cart is full");
			} finally {
				p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
				l.setAlignmentX(Component.CENTER_ALIGNMENT);
				p.add(Box.createVerticalGlue());
				p.add(l);
				p.add(Box.createVerticalGlue());
				d.add(p);
				d.setSize(200,100);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				int w = d.getSize().width;
		        int h = d.getSize().height;
		        int x = (dim.width - w) / 2;
		        int y = (dim.height - h) / 2;
		        d.setLocation(x,y);
				d.setVisible(true);
			}
		}
	}
	
	private class DetailsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel p = new JPanel();
			JDialog d = new JDialog();
			JLabel l = new JLabel("<html>" + media.getDetails().replaceAll("\n", "<br/>") + "</html>", SwingConstants.CENTER);
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			l.setAlignmentX(Component.CENTER_ALIGNMENT);
			p.add(Box.createVerticalGlue());
			p.add(l);
			p.add(Box.createVerticalGlue());
			d.add(p);
			d.setSize(200,200);
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			int w = d.getSize().width;
	        int h = d.getSize().height;
	        int x = (dim.width - w) / 2;
	        int y = (dim.height - h) / 2;
	        d.setLocation(x,y);
			d.setVisible(true);
		}
		
	}
}
