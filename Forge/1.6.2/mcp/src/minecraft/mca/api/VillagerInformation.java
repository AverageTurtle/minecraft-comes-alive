/*******************************************************************************
 * VillagerInformation.java
 * Copyright (c) 2013 WildBamaBoy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package mca.api;

public final class VillagerInformation 
{
	/** The villager's entity id. */
	public final int entityId;
	
	/** The villager's name. */
	public final String name;
	
	/** The villager's type, such as VillagerAdult, VillagerChild, or PlayerChild. */
	public final EnumVillagerType type;
	
	/** 
	 * The villager's profession id. MCA reserves -1 through 7 by default.
	 * 
	 * -1 = Kid (Villager Child), 0 = Farmer, 1 = Librarian, 2 = Priest, 
	 * 3 = Smith, 4 = Butcher, 5 = Guard, 6 = Baker, 7 = Miner
	 */
	public final int profession;

	/**
	 * True if this villager is actually holding a baby that is theirs.
	 * Will always be false for players' spouses.
	 */
	public final boolean hasBaby;

	public final boolean isMale;
	public final boolean isEngaged;
	public final boolean isMarriedToPlayer;
	public final boolean isMarriedToVillager;
	public final boolean isChild;
	
	public VillagerInformation(int entityId, String name, EnumVillagerType type, int profession, boolean isMale, 
			boolean isEngaged, boolean isMarriedToPlayer, boolean isMarriedToVillager, boolean hasBaby,
			boolean isChild)
	{
		this.entityId = entityId;
		this.name = name;
		this.type = type;
		this.profession = profession;
		this.isMale = isMale;
		this.isEngaged = isEngaged;
		this.isMarriedToPlayer = isMarriedToPlayer;
		this.isMarriedToVillager = isMarriedToVillager;
		this.hasBaby = hasBaby;
		this.isChild = isChild;
	}
}