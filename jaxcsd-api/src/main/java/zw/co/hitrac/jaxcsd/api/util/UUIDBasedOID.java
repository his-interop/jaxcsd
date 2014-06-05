/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.jaxcsd.api.util;

import java.math.BigInteger;
import java.util.UUID;

/**
 * <p>A class for creating and converting UUID based OIDs.</p>
 *
 * <p>See <a
 * href="http://www.itu.int/ITU-T/studygroups/com17/oid/X.667-E.pdf">ITU X.667
 * Information technology - Open Systems Interconnection - Procedures for the
 * operation of OSI Registration Authorities: Generation and registration of
 * Universally Unique Identifiers (UUIDs) and their use as ASN.1 Object
 * Identifier components</a>.</p>
 *
 * @author dclunie
 */
public class UUIDBasedOID {

    private static final String identString = "@(#) $Header: /userland/cvs/pixelmed/imgbook/com/pixelmed/utils/UUIDBasedOID.java,v 1.2 2009/11/05 00:06:06 dclunie Exp $";
    protected static final String OID_PREFIX = "2.25";    // {joint-iso-itu-t uuid(25) <uuid-single-integer-value>}
    protected static final String OID_PREFIX_REMOVAL_REGEX = "^" + OID_PREFIX + ".";
    protected UUID uuid;
    protected String oid;

    /**
     * <p>Construct a new OID with a new random UUID.</p>
     */
    public UUIDBasedOID() {
        uuid = UUID.randomUUID();
        oid = createOIDFromUUIDCanonicalHexString(uuid.toString());
    }

    /**
     * <p>Construct an OID from an existing string representation of an OID.</p>
     *
     * @param oid a String of dotted numeric values in OID form {joint-iso-itu-t
     * uuid(25) <uuid-single-integer-value>}
     */
    public UUIDBasedOID(String oid) throws IllegalArgumentException, NumberFormatException {
        this.oid = oid;
        uuid = parseUUIDFromOID(oid);
    }

    /**
     * <p>Get the string representation of the OID.</p>
     *
     * @return the string representation of the OID
     */
    public String getOID() {
        return oid;
    }

    /**
     * <p>Get the UUID of the OID.</p>
     *
     * @return the UUID
     */
    public UUID getUUID() {
        return uuid;
    }

    /**
     * <p>Extract the UUID from a UUID-based OID.</p>
     *
     * @param oid a String of dotted numeric values in OID form {joint-iso-itu-t
     * uuid(25) <uuid-single-integer-value>}
     * @return the UUID
     * @exception IllegalArgumentException if the OID is not in the
     * {joint-iso-itu-t uuid(25)} arc
     * @exception NumberFormatException if the OID does not contain a
     * uuid-single-integer-value
     */
    public static UUID parseUUIDFromOID(String oid) throws IllegalArgumentException, NumberFormatException {
        if (oid == null || !oid.startsWith(OID_PREFIX)) {
            throw new IllegalArgumentException("OID " + oid + " does not start with " + OID_PREFIX);
        }
        String decimalString = oid.replaceFirst(OID_PREFIX_REMOVAL_REGEX, "");
        return parseUUIDFromDecimalString(decimalString);
    }

    /**
     * <p>Extract the UUID from its single integer value decimal string
     * representation.</p>
     *
     * @param decimalString single integer value decimal string representation
     * @return the UUID
     * @exception NumberFormatException if the OID does not contain a
     * uuid-single-integer-value
     */
    public static UUID parseUUIDFromDecimalString(String decimalString) throws NumberFormatException {
        BigInteger decimalValue = new BigInteger(decimalString);
        long leastSignificantBits = decimalValue.longValue();
        long mostSignificantBits = decimalValue.shiftRight(64).longValue();
        return new UUID(mostSignificantBits, leastSignificantBits);
    }

    /**
     * <p>Convert an unsigned value in a long to a BigInteger.</p>
     *
     * @param unsignedLongValue an unsigned long value (i.e., the sign bit is
     * treated as part of the value rather than a sign)
     * @return the BigInteger
     */
    public static BigInteger makeBigIntegerFromUnsignedLong(long unsignedLongValue) {
//System.err.println("makeBigIntegerFromUnsignedLong(): unsignedLongValue = "+Long.toHexString(unsignedLongValue));
        BigInteger bigValue;
        if (unsignedLongValue < 0) {
            unsignedLongValue = unsignedLongValue & Long.MAX_VALUE;
            bigValue = BigInteger.valueOf(unsignedLongValue);
            bigValue = bigValue.setBit(63);
        } else {
            bigValue = BigInteger.valueOf(unsignedLongValue);
        }
        //System.err.println("makeBigIntegerFromUnsignedLong(): bigValue = "+com.pixelmed.utils.HexDump.dump(bigValue.toByteArray()));
        return bigValue;
    }

    /**
     * <p>Create an OID from the canonical hex string form of a UUID.</p>
     *
     * @param hexString canonical hex string form of a UUID
     * @return the OID
     * @exception IllegalArgumentException if name does not conform to the
     * string representation
     */
    public static String createOIDFromUUIDCanonicalHexString(String hexString) throws IllegalArgumentException {
        UUID uuid = UUID.fromString(hexString);
        long leastSignificantBits = uuid.getLeastSignificantBits();
        long mostSignificantBits = uuid.getMostSignificantBits();
        BigInteger decimalValue = makeBigIntegerFromUnsignedLong(mostSignificantBits);
        decimalValue = decimalValue.shiftLeft(64);
        BigInteger bigValueOfLeastSignificantBits = makeBigIntegerFromUnsignedLong(leastSignificantBits);
        decimalValue = decimalValue.or(bigValueOfLeastSignificantBits);   // not add() ... do not want to introduce question of signedness of long
        return OID_PREFIX + "." + decimalValue.toString();
    }
}
